package com.estg.mtsds.moviereserve.service;

import com.estg.mtsds.moviereserve.entity.Movie;
import com.estg.mtsds.moviereserve.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies(){
        return this.movieRepository.findAll();
    }

    public Movie saveMovie(Movie m){
        return this.movieRepository.save(m);
    }
}
