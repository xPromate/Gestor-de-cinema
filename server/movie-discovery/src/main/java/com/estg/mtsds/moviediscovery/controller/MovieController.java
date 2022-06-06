package com.estg.mtsds.moviediscovery.controller;

import com.estg.mtsds.moviediscovery.entity.Movie;
import com.estg.mtsds.moviediscovery.model.CinemaRoom;
import com.estg.mtsds.moviediscovery.model.Seat;
import com.estg.mtsds.moviediscovery.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    //método teste para apagar depois
    @PostMapping("/create")
    public Movie saveMovie() {
        CinemaRoom cinemaRoom = new CinemaRoom("Sala 1");
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatterHour = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");

        Seat[][] seats = new Seat[8][6];

        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                seats[i][j] = new Seat();
            }
        }

        calendar.set(2021, Calendar.APRIL, 20, 19, 45, 0);
        seats[0][0].setOccupied(true);
        seats[0][0].setReservationId("id069");
        seats[0][0].setDateTime("15:03:34");
        seats[0][0].setPaid(true);

        Movie m = new Movie("1", "Iron Man 1", formatterDate.format((calendar.getTime())), formatterHour.format(calendar.getTime()), cinemaRoom);

        cinemaRoom.setSeats(seats);
        m.setCinemaRoom(cinemaRoom);

        return this.movieService.saveMovie(m);
    }

    @CrossOrigin
    @GetMapping("/all")
    public List<Movie> showAllMovies() throws ParseException {
        List<Movie> movieList = this.movieService.showAllMovies();
        List<Movie> availableMovies = new LinkedList<>();
        Date now = new Date();

        for(Movie m: movieList){
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String movieDateTime = m.getExhibitionDate() + " " + m.getExhibitionHour();
            Date date = format.parse(movieDateTime);

            if(!m.isFull() && now.before(date)){
                availableMovies.add(m);
            }
        }

        return availableMovies;
    }
}
