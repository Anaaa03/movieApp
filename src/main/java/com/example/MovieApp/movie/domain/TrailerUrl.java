package com.example.MovieApp.movie.domain;

import lombok.NonNull;
import lombok.Value;

@Value
public class TrailerUrl {
    @NonNull
    String value;

    public TrailerUrl(@NonNull String value) {
        this.value = value;
    }
}
