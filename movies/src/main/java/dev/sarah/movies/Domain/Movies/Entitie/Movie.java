package dev.sarah.movies.Domain.Movies.Entitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*; 
import org.springframework.data.annotation.Id;

import dev.sarah.movies.Domain.Reviews.Entitie.Review;

import java.util.List;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String imdbId;

    private String title;

    private String releaseDate;

    private String trailerLink;

    private String poster;

    @ElementCollection
    @CollectionTable(name = "movie_backdrops", joinColumns = @JoinColumn(name = "movie_id"))   
    @Column(name = "backdrop") 
    private List<String> backdrops;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Review> reviewId;

}
