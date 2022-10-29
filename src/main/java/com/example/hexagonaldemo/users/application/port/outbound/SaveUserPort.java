package com.example.hexagonaldemo.users.application.port.outbound;

import com.example.hexagonaldemo.users.domain.WikiUser;

public interface SaveUserPort {
    void save(WikiUser wikiUser);
}
