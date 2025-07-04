package com.example.MovieApp.movie.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "trailer_url", columnDefinition = "text")
    private String trailerUrl;

    @Lob
    @Column(name = "poster_image", columnDefinition = "bytea")
    private byte[] posterImage;
}
