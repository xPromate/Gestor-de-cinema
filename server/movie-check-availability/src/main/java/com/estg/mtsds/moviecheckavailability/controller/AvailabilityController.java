package com.estg.mtsds.moviecheckavailability.controller;

import com.estg.mtsds.moviecheckavailability.entity.Movie;
import com.estg.mtsds.moviecheckavailability.model.MovieInfoBody;
import com.estg.mtsds.moviecheckavailability.service.MovieAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/checkMovieAvailability")
public class AvailabilityController {

    @Autowired
    private MovieAvailabilityService movieAvailabilityService;

    @CrossOrigin
    @PostMapping(value = "/availability",consumes = {"application/json"})
    public HashMap<String, Object> checkMultiplePlaces(@RequestBody MovieInfoBody movieInfoBody) {
        HashMap<String, Object> hashMap = new HashMap<>();
        List<Movie> moviesList = this.movieAvailabilityService.getAllMovies();
        String eventId = null;

        boolean canSeat = true;
        boolean movieFound = false;

        for (Movie movie : moviesList) {
            if (movie.getMovieName().equals(movieInfoBody.getMovieName()) && movie.getExhibitionDate().equals(movieInfoBody.getExhibitionDate()) && movie.getExhibitionHour().equals(movieInfoBody.getExhibitionHour())) {
                movieFound = true;
                eventId = movie.getId();
            }
            if (movieFound) {
                for (int i = 0; i < movieInfoBody.getX().length; i++) {
                    if (movie.getCinemaRoom().getSeats()[movieInfoBody.getX()[i]][movieInfoBody.getY()[i]].isOccupied()) {
                        canSeat = false;
                        break;
                    }
                }
                break;
            }
        }

        if (canSeat && movieFound) {
            hashMap.put("eventId", eventId);
            hashMap.put("x", movieInfoBody.getX());
            hashMap.put("y", movieInfoBody.getY());
            hashMap.put("canSeat", true);
        } else {
            hashMap.put("eventId", eventId);
            hashMap.put("x", movieInfoBody.getX());
            hashMap.put("y", movieInfoBody.getY());
            hashMap.put("canSeat", false);
        }

        return hashMap;
    }
}
