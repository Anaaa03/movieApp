package com.example.MovieApp.movie.domain;

import lombok.Getter;

@Getter
public class Movie {
    Title title;
    int releaseYear;
    int durationMinutes;
    Description description;
    TrailerUrl trailerUrl;
    Poster poster;

    public Movie(Title title, int releaseYear, int durationMinutes, Description description, TrailerUrl trailerUrl, Poster poster) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.durationMinutes = durationMinutes;
        this.description = description;
        this.trailerUrl = trailerUrl;
        this.poster = poster;
    }
// metoda fabrykująca zamiast przez konstruktor tworzyc
//    public static Movie create(
//            Title title,
//            int releaseYear,
//            int durationMinutes,
//            Description description,
//            TrailerUrl trailerUrl,
//            Poster poster
//    ) {
//        if (durationMinutes < 60) throw new IllegalArgumentException("Movies can't be shorter than 1h");
//        return new Movie(title, releaseYear, durationMinutes, description, trailerUrl, poster);
//    }

    public static Movie restoreFromPersistence(
        Title title,
        int releaseYear,
        int durationMinutes,
        Description description,
        TrailerUrl trailerUrl,
        Poster poster
    ){
        return new Movie(title, releaseYear, durationMinutes, description, trailerUrl, poster);
    }
}
