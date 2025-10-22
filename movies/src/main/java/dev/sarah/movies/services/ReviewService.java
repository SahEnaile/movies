package dev.sarah.movies.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import dev.sarah.movies.Domain.Movies.Entitie.Movie;
import dev.sarah.movies.Domain.Reviews.Entitie.Review;
import dev.sarah.movies.repositorys.ReviewRepository;
import dev.sarah.movies.repositorys.MovieRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;
    
    @Transactional 
    public Review createReview(String reviewBody, String imdbId) {
        
        Optional<Movie> movieOptional = movieRepository.findByImdbId(imdbId);
        
        if (!movieOptional.isPresent()) {
            throw new RuntimeException("Movie not found with imdbId: " + imdbId);
        }
        
        Movie movie = movieOptional.get();
        Review review = new Review(reviewBody, movie); 
        review = reviewRepository.save(review); 
        movie.getReviewId().add(review);
        
        return review;
    }

}
