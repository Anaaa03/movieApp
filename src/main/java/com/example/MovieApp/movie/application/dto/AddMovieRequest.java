package com.example.MovieApp.movie.application.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AddMovieRequest {
    private String title;
    private int releaseYear;
    private int durationMinutes;
    private String description;
    private String trailerUrl;
    private MultipartFile posterImage;
}
