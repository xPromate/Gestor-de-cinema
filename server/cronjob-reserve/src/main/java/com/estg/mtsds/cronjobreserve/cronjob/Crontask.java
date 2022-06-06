package com.estg.mtsds.cronjobreserve.cronjob;

import com.estg.mtsds.cronjobreserve.entity.Movie;
import com.estg.mtsds.cronjobreserve.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class Crontask {

    @Autowired
    private MovieService movieService;

    @Scheduled(fixedRate = 30000)
    public void reportCurrentTime() throws ParseException {
        SimpleDateFormat formatterHour = new SimpleDateFormat("HH:mm:ss");
        formatterHour.format(Calendar.getInstance().getTime());
        

        List<Movie>  tmp = movieService.getAllMovies();


        for(int i = 0; i < tmp.size() ; i++){
            for(int j = 0; j < tmp.get(i).getCinemaRoom().getSeats().length ; j++){
                for(int k = 0; k < tmp.get(i).getCinemaRoom().getSeats()[j].length ; k++){
                    if(!tmp.get(i).getCinemaRoom().getSeats()[j][k].isPaid() && tmp.get(i).getCinemaRoom().getSeats()[j][k].isOccupied()){
                        Movie movieTmp = tmp.get(i);
                        boolean flag = false;
                        String stringTmp = tmp.get(i).getCinemaRoom().getSeats()[j][k].getDateTime();
                        String[] splitted = stringTmp.split(":");
                        int actualMins = LocalDateTime.now().getMinute();
                        int tmpMins = 0;
                        if(String.valueOf(splitted[1].charAt(0)).equals("0")){
                            tmpMins = Integer.parseInt(String.valueOf(splitted[1].charAt(1)));
                        }else{
                            tmpMins = Integer.parseInt(splitted[1]);
                        }

                        if(actualMins - tmpMins > 2){ //método teste
                            movieTmp.getCinemaRoom().getSeats()[j][k].setOccupied(false);
                            movieTmp.getCinemaRoom().getSeats()[j][k].setReservationId("");
                            movieTmp.getCinemaRoom().getSeats()[j][k].setDateTime("");
                            flag = true;
                        }

                        if(flag){
                            movieService.saveMovie(movieTmp);
                        }


                    }
                }
            }
        }

    }




}
