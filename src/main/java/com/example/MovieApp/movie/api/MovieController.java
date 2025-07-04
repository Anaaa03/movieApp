package com.example.MovieApp.movie.api;

import com.example.MovieApp.movie.application.AddMovieUseCase;
import com.example.MovieApp.movie.application.dto.AddMovieRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final AddMovieUseCase addMovieUseCase;

    public MovieController(AddMovieUseCase addMovieUseCase) {
        this.addMovieUseCase = addMovieUseCase;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addMovie(
            @RequestParam("title") String title,
            @RequestParam("releaseYear") int releaseYear,
            @RequestParam("durationMinutes") int durationMinutes,
            @RequestParam("description") String description,
            @RequestParam("trailerUrl") String trailerUrl,
            @RequestParam("posterImage") MultipartFile posterImage){
        AddMovieRequest request = new AddMovieRequest();
        request.setTitle(title);
        request.setReleaseYear(releaseYear);
        request.setDurationMinutes(durationMinutes);
        request.setDescription(description);
        request.setTrailerUrl(trailerUrl);
        request.setPosterImage(posterImage);

        addMovieUseCase.addMovie(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    }




