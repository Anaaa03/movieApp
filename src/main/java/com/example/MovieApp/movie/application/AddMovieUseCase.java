package com.example.MovieApp.movie.application;

import com.example.MovieApp.movie.application.dto.AddMovieRequest;
import com.example.MovieApp.movie.domain.*;
import com.example.MovieApp.movie.infrastructure.persistence.MovieRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class AddMovieUseCase {
    private final MovieRepository movieRepository;


    public AddMovieUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void addMovie(AddMovieRequest request) {
        Title title = new Title(request.getTitle());
        Description description = new Description(request.getDescription());
        TrailerUrl trailer = new TrailerUrl(request.getTrailerUrl());

        Poster poster;
        MultipartFile file = request.getPosterImage();
        if (file != null && !file.isEmpty()) {
            try {
                poster = new Poster(file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Błąd odczytu pliku obrazu", e);
            }

            Movie movie = new Movie(title, request.getReleaseYear(), request.getDurationMinutes(), description, trailer, poster);
//            Movie movie = Movie.create(
//                    title,
//                    request.getReleaseYear(),
//                    request.getDurationMinutes(),
//                    description,
//                    trailer,
//                    poster
//            );

            movieRepository.save(movie);
        }
    }
}





















//    private final MovieRepository movieRepository;
//
//    @Transactional
//    public void addMovie(AddMovieRequest request) {
//        // Tworzenie VO na podstawie requesta
//        Title title = new Title(request.getTitle());
//        Description description = new Description(request.getDescription());
//        TrailerUrl trailerUrl = new TrailerUrl(request.getTrailerUrl());
//        Poster posterImage = null;
//
//        // Obsługa MultipartFile (może być null)
//        if (request.getPosterImage() != null && !request.getPosterImage().isEmpty()) {
//            try {
//                posterImage = new Poster(request.getPosterImage().getBytes());
//            } catch (Exception e) {
//                // Możesz dodać własną obsługę błędów
//                throw new RuntimeException("Błąd podczas przetwarzania obrazu", e);
//            }
//        }
//
//        Movie movie = Movie.create(
//                title,
//                request.getReleaseYear(),
//                request.getDurationMinutes(),
//                description,
//                trailerUrl,
//                posterImage
//        );
//
//        movieRepository.save(movie); // zapis przez repozytorium
//    }
//
//
