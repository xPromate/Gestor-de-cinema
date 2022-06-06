package com.estg.mtsds.moviecheckavailability.repository;

import com.estg.mtsds.moviecheckavailability.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

}
