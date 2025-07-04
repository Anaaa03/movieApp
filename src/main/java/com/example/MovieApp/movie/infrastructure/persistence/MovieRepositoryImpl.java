package com.example.MovieApp.movie.infrastructure.persistence;

import com.example.MovieApp.movie.domain.Movie;
import com.example.MovieApp.movie.domain.MovieRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    private final JpaMovieRepository jpaMovieRepository;

    public MovieRepositoryImpl(JpaMovieRepository jpaMovieRepository) {
        this.jpaMovieRepository = jpaMovieRepository;
    }


    @Override
    public void save(Movie movie) {
        jpaMovieRepository.save(MovieMapper.toEntity(movie));
    }
}
