package com.example.MovieApp.domain.user;

import lombok.Getter;

import java.time.Instant;
import java.util.Objects;

@Getter
public class User {
    private final UserId id;
    private final String username;
    private Email email;
    private String passwordHash;
    private final Instant createdAt;
    private boolean active;

    public User(UserId id, String username, Email email, String passwordHash, Instant createdAt) {
        this.id = Objects.requireNonNull(id);
        this.username = Objects.requireNonNull(username);
        this.email = Objects.requireNonNull(email);
        this.passwordHash = Objects.requireNonNull(passwordHash);
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.active = false;
    }

//    public void activate() {
//        if (this.active) {
//            throw new IllegalStateException("User is already active.");
//        }
//        this.active = true;
//    }
//
//    public void changeEmail(Email newEmail) {
//        if (this.email.equals(newEmail)) {
//            throw new IllegalArgumentException("New email must be different.");
//        }
//        this.email = newEmail;
//    }
//
//    public boolean checkPassword(String rawPassword, PasswordEncoder encoder) {
//        return encoder.matches(rawPassword, this.passwordHash);
//    }
//
//    public void changePassword(String oldPassword, String newPassword, PasswordEncoder encoder) {
//        if (!checkPassword(oldPassword, encoder)) {
//            throw new IllegalArgumentException("Current password does not match.");
//        }
//        this.passwordHash = encoder.encode(newPassword);
//    }
}
