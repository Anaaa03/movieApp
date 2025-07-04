package com.example.MovieApp.movie.domain;

import lombok.NonNull;
import lombok.Value;

@Value
public class Description {
    @NonNull
    String value;

    public Description(@NonNull String value) {
        this.value = value;
    }
}
