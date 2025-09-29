package dev.sarah.movies.repositorys;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import dev.sarah.movies.entities.Movie;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


    Optional<Movie> findByImdbId(String imdbId);

}
