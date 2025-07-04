package com.example.MovieApp.movie.domain;

import lombok.NonNull;
import lombok.Value;

@Value
public class Poster {
    byte[] imageData;

    public Poster(byte[] imageData) {
        this.imageData = imageData;
    }
}
