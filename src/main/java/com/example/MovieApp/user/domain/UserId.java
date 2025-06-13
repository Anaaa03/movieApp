package com.example.MovieApp.domain.user;

import lombok.Value;

import java.util.UUID;

@Value
public class UserId {
    UUID value;

    public static UserId generate() {
        return new UserId(UUID.randomUUID());
    }
}
