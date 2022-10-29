package com.example.hexagonaldemo.users.domain;

public class WikiUser {

    private final String id;
    private final String email;
    private final String name;


    public WikiUser(String id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
