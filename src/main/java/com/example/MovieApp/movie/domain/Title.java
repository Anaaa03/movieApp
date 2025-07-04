package com.example.MovieApp.movie.domain;

import lombok.NonNull;
import lombok.Value;

@Value
public class Title {
    @NonNull
    String value;

    public Title(@NonNull String value) {
        this.value = value;
    }
}
