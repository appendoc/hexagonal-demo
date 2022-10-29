package com.example.hexagonaldemo.users.application.port.inbound;

public interface SignUpUseCase {

    record SignUpRequest(String email, String name) {
    }

    record SignUpResponse(String id) {
    }

    SignUpResponse signUp(SignUpRequest request);
}
