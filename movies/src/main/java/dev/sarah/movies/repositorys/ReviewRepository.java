package dev.sarah.movies.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import dev.sarah.movies.domain.reviews.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}