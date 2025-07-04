package com.example.MovieApp.movie.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovieRepository extends JpaRepository <MovieEntity, Long> {
}
