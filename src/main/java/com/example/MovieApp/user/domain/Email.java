package com.example.MovieApp.user.domain;

import lombok.NonNull;
import lombok.Value;

@Value
public class Email {
    @NonNull
    String value;

    public Email(@NonNull String value) {
        this.value = value;
    }
}
