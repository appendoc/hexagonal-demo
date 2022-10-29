package com.example.hexagonaldemo.documents.application.port.inbound;

public interface SubscribeUserSignUpEventUseCase {

    record SignUpEventForDocument(String authorId) {
    }

    void onSignUp(SignUpEventForDocument signUpEventForDocument);
}
