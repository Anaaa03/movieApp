package com.example.MovieApp.user.domain;

import lombok.Getter;
import java.time.Instant;

@Getter
public class User {
    UserId id;
    Username username;
    Email email;
    String passwordHash;
    Instant createdAt;

    private User(UserId id, Username username, Email email, String passwordHash, Instant createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.createdAt = createdAt;
    }

    public static User createNewUser(Username username, Email email, String passwordHash){
        UserId id = null;
        Instant createdAt = Instant.now();
        return new User(id, username, email, passwordHash, createdAt);
    }

    public static User restoreFromPersistence(
            UserId id, Username username, Email email, String passwordHash, Instant createdAt) {
        return new User(id, username, email, passwordHash, createdAt);
    }

}
