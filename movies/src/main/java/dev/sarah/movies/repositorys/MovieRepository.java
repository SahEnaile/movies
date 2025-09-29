package dev.sarah.movies.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.sarah.movies.entities.Movie;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {


    Optional<Movie> findMovieByImdbId(String imdbId);

}
