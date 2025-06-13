package com.example.MovieApp.domain.user;

import lombok.Value;

@Value
public class Email {
    String value;

    public Email(String value) {
        if (!value.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.value = value;
    }
}
