package com.estg.mtsds.moviediscovery.service;

import com.estg.mtsds.moviediscovery.entity.Movie;
import com.estg.mtsds.moviediscovery.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    public List<Movie> showAllMovies() {
        return this.movieRepository.findAll();
    }
}
