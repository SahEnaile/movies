package dev.sarah.movies.services;

import org.springframework.stereotype.Service;

import dev.sarah.movies.domain.movies.entities.Movie;
import dev.sarah.movies.repositories.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }

    public Movie newMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(String imdbId, Movie movie) {
        Movie existingMovie = movieRepository.findByImdbId(imdbId)
                .orElseThrow(() -> new RuntimeException("Movie not found with imdbId: " + imdbId));
        
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setReleaseDate(movie.getReleaseDate());
        existingMovie.setTrailerLink(movie.getTrailerLink());
        existingMovie.setPoster(movie.getPoster());
        existingMovie.setBackdrops(movie.getBackdrops());

        return movieRepository.save(existingMovie);
    }
}