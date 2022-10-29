package com.example.hexagonaldemo.documents.application.service;

import com.example.hexagonaldemo.documents.application.port.inbound.SubscribeUserSignUpEventUseCase;
import com.example.hexagonaldemo.documents.application.port.outbound.SaveWikiDocumentPort;
import com.example.hexagonaldemo.documents.domain.WikiDocument;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SubscribeUserSignUpEventUseCaseImpl implements SubscribeUserSignUpEventUseCase {

    private final SaveWikiDocumentPort saveWikiDocumentPort;

    public SubscribeUserSignUpEventUseCaseImpl(SaveWikiDocumentPort saveWikiDocumentPort) {
        this.saveWikiDocumentPort = saveWikiDocumentPort;
    }

    @Override
    public void onSignUp(SignUpEventForDocument signUpEventForDocument) {
        System.out.println("ㅠㅠㅠㅠㅠㅠㅠㅠ");
        final WikiDocument newWikiDocument = new WikiDocument(
                UUID.randomUUID().toString(),
                signUpEventForDocument.authorId(),
                "새로운 사용자 문서에요."
        );
        saveWikiDocumentPort.save(newWikiDocument);
    }
}
