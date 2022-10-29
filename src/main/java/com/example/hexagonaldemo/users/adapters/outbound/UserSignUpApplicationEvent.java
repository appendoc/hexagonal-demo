package com.example.hexagonaldemo.users.adapters.outbound;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserSignUpApplicationEvent extends ApplicationEvent {

    private final String newUserId;

    public UserSignUpApplicationEvent(Object source, String newUserId) {
        super(source);
        this.newUserId = newUserId;
    }
}
