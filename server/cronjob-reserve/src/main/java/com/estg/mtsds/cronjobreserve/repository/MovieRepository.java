package com.estg.mtsds.cronjobreserve.repository;

import com.estg.mtsds.cronjobreserve.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
