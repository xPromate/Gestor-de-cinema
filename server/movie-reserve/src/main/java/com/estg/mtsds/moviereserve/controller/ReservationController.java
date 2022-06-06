package com.estg.mtsds.moviereserve.controller;

import com.estg.mtsds.moviereserve.entity.Movie;
import com.estg.mtsds.moviereserve.model.MovieToReserveInfo;
import com.estg.mtsds.moviereserve.service.ReservationService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @RabbitListener(queues = "movie-reservation-queue")
    public void makeMovieReserve(String message) {
        Gson g = new Gson();
        MovieToReserveInfo movieToReserveInfo = g.fromJson(message, MovieToReserveInfo.class);
        String eventId = movieToReserveInfo.getEventId();
        List<Movie> moviesList = reservationService.getMovies();
        Movie m = null;
        SimpleDateFormat formatterHour = new SimpleDateFormat("HH:mm:ss");
        int[] x = movieToReserveInfo.getX();
        int[] y = movieToReserveInfo.getY();

        for (Movie movie : moviesList) {
            if (movie.getId().equals(eventId)) {
                m = movie;
                break;
            }
        }

        if (m != null) {
            for (int i = 0; i < x.length; i++) {
                if (!m.getCinemaRoom().getSeats()[x[i]][y[i]].isOccupied()) {
                    m.getCinemaRoom().getSeats()[x[i]][y[i]].setOccupied(true);
                    m.getCinemaRoom().getSeats()[x[i]][y[i]].setReservationId(movieToReserveInfo.getReservationId());
                    m.getCinemaRoom().getSeats()[x[i]][y[i]].setDateTime(formatterHour.format(Calendar.getInstance().getTime()));
                } else if(m.getCinemaRoom().getSeats()[x[i]][y[i]].isOccupied() && !m.getCinemaRoom().getSeats()[x[i]][y[i]].isPaid()){
                    m.getCinemaRoom().getSeats()[x[i]][y[i]].setPaid(true);
                }
            }

            this.reservationService.saveMovie(m);
        }
    }
}
