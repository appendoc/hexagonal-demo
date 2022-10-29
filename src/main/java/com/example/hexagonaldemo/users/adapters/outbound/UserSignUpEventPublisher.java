package com.example.hexagonaldemo.users.adapters.outbound;

import com.example.hexagonaldemo.users.application.port.outbound.PublishUserSignUpEventPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserSignUpEventPublisher implements PublishUserSignUpEventPort {

    private final ApplicationEventPublisher applicationEventPublisher;

    public UserSignUpEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publish(UserSignUpEvent userSignUpEvent) {
        final UserSignUpApplicationEvent userSignUpApplicationEvent = new UserSignUpApplicationEvent(this, userSignUpEvent.newUserId());
        applicationEventPublisher.publishEvent(userSignUpApplicationEvent);
        log.info("UserSignUpEvent has been published." + userSignUpEvent);
    }
}
