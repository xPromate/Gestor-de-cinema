package com.estg.mtsds.cronjobreserve.service;

import com.estg.mtsds.cronjobreserve.entity.Movie;
import com.estg.mtsds.cronjobreserve.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

}
