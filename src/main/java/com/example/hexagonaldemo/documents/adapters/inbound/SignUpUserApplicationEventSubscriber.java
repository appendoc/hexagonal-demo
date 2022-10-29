package com.example.hexagonaldemo.documents.adapters.inbound;

import com.example.hexagonaldemo.documents.application.port.inbound.SubscribeUserSignUpEventUseCase;
import com.example.hexagonaldemo.users.adapters.outbound.UserSignUpApplicationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SignUpUserApplicationEventSubscriber implements ApplicationListener<UserSignUpApplicationEvent> {

    private final SubscribeUserSignUpEventUseCase useCase;

    public SignUpUserApplicationEventSubscriber(SubscribeUserSignUpEventUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void onApplicationEvent(UserSignUpApplicationEvent event) {
        log.info("New event for sign-up: " + event);
        useCase.onSignUp(
                new SubscribeUserSignUpEventUseCase.SignUpEventForDocument(event.getNewUserId())
        );
    }
}
