package com.estg.mtsds.moviecheckavailability.service;

import com.estg.mtsds.moviecheckavailability.entity.Movie;
import com.estg.mtsds.moviecheckavailability.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieAvailabilityService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return this.movieRepository.findAll();
    }
}
