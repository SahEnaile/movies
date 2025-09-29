package dev.sarah.movies.entities;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*; 

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private String body;

    private Long id;

    @ManyToMany
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    public Review(String body, Movie movie) {
        this.body = body;
        this.movie = movie;
    }
}
