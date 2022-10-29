package com.example.hexagonaldemo.users.application.service;

import com.example.hexagonaldemo.users.application.port.inbound.SignUpUseCase;
import com.example.hexagonaldemo.users.application.port.outbound.LoadUserPort;
import com.example.hexagonaldemo.users.application.port.outbound.PublishUserSignUpEventPort;
import com.example.hexagonaldemo.users.application.port.outbound.SaveUserPort;
import com.example.hexagonaldemo.users.domain.WikiUser;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SignUpUseCaseImpl implements SignUpUseCase {

    private final LoadUserPort loadUserPort;
    private final SaveUserPort saveUserPort;
    private final PublishUserSignUpEventPort publishUserSignUpEventPort;

    public SignUpUseCaseImpl(
            LoadUserPort loadUserPort,
            SaveUserPort saveUserPort,
            PublishUserSignUpEventPort publishUserSignUpEventPort
    ) {
        this.loadUserPort = loadUserPort;
        this.saveUserPort = saveUserPort;
        this.publishUserSignUpEventPort = publishUserSignUpEventPort;
    }

    @Override
    public SignUpResponse signUp(SignUpRequest request) {
        final String emailToFindExistingUser = request.email();
        final boolean isExistingUser = loadUserPort.loadByEmail(emailToFindExistingUser) != null;
        if (isExistingUser) {
            throw new RuntimeException("Email already taken!");
        }
        final String newId = UUID.randomUUID().toString();
        final WikiUser newWikiUser = new WikiUser(newId, request.email(), request.name());
        saveUserPort.save(newWikiUser);
        publishUserSignUpEventPort.publish(
                new PublishUserSignUpEventPort.UserSignUpEvent(newWikiUser.getId())
        );
        return new SignUpResponse(newId);
    }
}
