package dev.sarah.movies.services;

import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import dev.sarah.movies.domain.movies.entities.Movie;
import dev.sarah.movies.domain.reviews.entities.Review;
import dev.sarah.movies.repositories.ReviewRepository;
import dev.sarah.movies.repositories.MovieRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }
    
    @Transactional 
    public Review createReview(String reviewBody, String imdbId) {
        Movie movie = movieRepository.findByImdbId(imdbId)
                .orElseThrow(() -> new RuntimeException("Movie not found with imdbId: " + imdbId));
        
        Review review = new Review(reviewBody, movie); 
        review = reviewRepository.save(review); 
        movie.getReviews().add(review);
        
        return review;
    }
}