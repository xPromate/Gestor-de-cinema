package com.mtsds.moviesadvertised.repository;

import com.mtsds.moviesadvertised.entity.MovieDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieDetailsRepository extends MongoRepository<MovieDetails,String> {


    MovieDetails findMovieById(String id);
}
