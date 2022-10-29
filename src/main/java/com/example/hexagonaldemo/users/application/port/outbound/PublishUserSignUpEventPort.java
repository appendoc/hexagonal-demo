package com.example.hexagonaldemo.users.application.port.outbound;

public interface PublishUserSignUpEventPort {
    record UserSignUpEvent(String newUserId) {
    }

    void publish(UserSignUpEvent userSignUpEvent);
}
