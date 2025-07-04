package com.example.MovieApp.movie.infrastructure.persistence;

import com.example.MovieApp.movie.application.dto.AddMovieRequest;
import com.example.MovieApp.movie.domain.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public class MovieMapper {
    public static MovieEntity toEntity(Movie movie) {
        MovieEntity entity = new MovieEntity();
        entity.setTitle(movie.getTitle().getValue());
        entity.setReleaseYear(movie.getReleaseYear());
        entity.setDurationMinutes(movie.getDurationMinutes());
        entity.setDescription(movie.getDescription().getValue());
        entity.setTrailerUrl(movie.getTrailerUrl().getValue());
        entity.setPosterImage(movie.getPoster().getImageData());
        return entity;
    }

    public static Movie toDomain(MovieEntity entity) {
        return Movie.restoreFromPersistence(
                new Title(entity.getTitle()),
                entity.getReleaseYear(),
                entity.getDurationMinutes(),
                new Description(entity.getDescription()),
                new TrailerUrl(entity.getTrailerUrl()),
                new Poster(entity.getPosterImage())
        );
    }

}
