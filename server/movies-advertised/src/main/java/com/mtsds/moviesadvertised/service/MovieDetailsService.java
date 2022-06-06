package com.mtsds.moviesadvertised.service;

import com.mtsds.moviesadvertised.entity.MovieDetails;
import com.mtsds.moviesadvertised.repository.MovieDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDetailsService {

    @Autowired
    private MovieDetailsRepository movieDetailsRepository;

    public MovieDetails saveMovie(MovieDetails movie){
        return this.movieDetailsRepository.save(movie);
    }

    public List<MovieDetails> showAllMovies(){
        return this.movieDetailsRepository.findAll();
    }

    public MovieDetails findMovieById(String id){
        return this.movieDetailsRepository.findMovieById(id);
    }

}
