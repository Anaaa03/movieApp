package com.example.MovieApp.user.domain;

import lombok.NonNull;
import lombok.Value;

@Value
public class Username {
    @NonNull
    String Value;

    public Username(@NonNull String value) {
        Value = value;
    }
}
