package dev.sarah.movies.repositorys;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import dev.sarah.movies.Domain.Reviews.Entitie.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
