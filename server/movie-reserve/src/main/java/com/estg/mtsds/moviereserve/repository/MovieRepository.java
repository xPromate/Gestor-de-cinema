package com.estg.mtsds.moviereserve.repository;

import com.estg.mtsds.moviereserve.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
