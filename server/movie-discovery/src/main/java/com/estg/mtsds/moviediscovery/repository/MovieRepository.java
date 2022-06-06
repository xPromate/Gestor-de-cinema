package com.estg.mtsds.moviediscovery.repository;

import com.estg.mtsds.moviediscovery.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
