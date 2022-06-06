package com.mtsds.moviesadvertised.controller;


import com.mtsds.moviesadvertised.entity.MovieDetails;
import com.mtsds.moviesadvertised.model.Person;
import com.mtsds.moviesadvertised.service.MovieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movieDetails")
public class MovieDetailsController {

    @Autowired
    private MovieDetailsService movieDetailsService;


    @GetMapping("/create")
    public MovieDetails saveMovie() throws IOException {

        Person persons[] = new Person[4];
        Person p1 = new Person("Mark Rufallo","https://upload.wikimedia.org/wikipedia/commons/6/61/Mark_Ruffalo_%2836243137665%29_%28cropped%29.jpg");
        Person p2 = new Person("Robert Downey Jr.", "https://www.diarioesportes.com/img/news_img/all/14443_2_1200.pic");
        Person p3 = new Person("Chris Evans", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Chris_Evans_SDCC_2014.jpg/1200px-Chris_Evans_SDCC_2014.jpg");
        Person p4 = new Person("Chris Hemsworth", "https://cdn.britannica.com/92/215392-050-96A4BC1D/Australian-actor-Chris-Hemsworth-2019.jpg");
        persons[0] = p1;
        persons[1] = p2;
        persons[2] = p3;
        persons[3] = p4;

        String[] genre = {"Ação","Comédia"};

        MovieDetails movieDetails = new MovieDetails("4","Iron Man","1h30","Inimigo Obadiah","inglês","português","https://www.youtube.com/watch?v=B65hW9YYY5A",persons,genre, "https://i.pinimg.com/originals/a4/f1/f6/a4f1f6c1efdb834471deaae8f77940c8.jpg",5);

        return movieDetailsService.saveMovie(movieDetails);
    }


    @CrossOrigin
    @GetMapping("/all")
    public List<MovieDetails> showAllMovies() {
        return movieDetailsService.showAllMovies();
    }

    @CrossOrigin
    @GetMapping("/movie/{id}")
    public MovieDetails movieDetails(@PathVariable("id") String id){
        return this.movieDetailsService.findMovieById(id);
    }
}
