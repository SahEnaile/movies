package dev.sarah.movies.repositorys;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.sarah.movies.entities.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
    