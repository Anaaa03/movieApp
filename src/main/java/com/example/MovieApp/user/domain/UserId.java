package com.example.MovieApp.user.domain;

import lombok.NonNull;
import lombok.Value;


@Value
public class UserId {
    @NonNull
    Long value;

    public UserId(@NonNull Long value) {
        this.value = value;
    }
}