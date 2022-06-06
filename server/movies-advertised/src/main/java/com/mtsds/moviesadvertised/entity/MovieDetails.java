package com.mtsds.moviesadvertised.entity;

import com.mtsds.moviesadvertised.model.Person;
import org.springframework.data.annotation.Id;

import java.util.Arrays;

public class MovieDetails {

    @Id
    private String id;
    private String title;
    private String durationTime;
    private String description;
    private String voiceLanguage;
    private String subtitleLanguage;
    private String trailerUrl;
    private Person[]  cast;
    private String [] genre;
    private String movieImageUrl;
    private int movieScore;

    public MovieDetails(String id, String title, String durationTime, String description, String voiceLanguage, String subtitleLanguage, String trailerUrl, Person[] cast, String[] genre, String movieImageUrl, int movieScore) {
        this.id = id;
        this.title = title;
        this.durationTime = durationTime;
        this.description = description;
        this.voiceLanguage = voiceLanguage;
        this.subtitleLanguage = subtitleLanguage;
        this.trailerUrl = trailerUrl;
        this.cast = cast;
        this.genre = genre;
        this.movieImageUrl = movieImageUrl;
        this.movieScore = movieScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVoiceLanguage() {
        return voiceLanguage;
    }

    public void setVoiceLanguage(String voiceLanguage) {
        this.voiceLanguage = voiceLanguage;
    }

    public String getSubtitleLanguage() {
        return subtitleLanguage;
    }

    public void setSubtitleLanguage(String subtitleLanguage) {
        this.subtitleLanguage = subtitleLanguage;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public Person[] getCast() {
        return cast;
    }

    public void setCast(Person[] cast) {
        this.cast = cast;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String getMovieImageUrl() {
        return movieImageUrl;
    }

    public void setMovieImageUrl(String movieImageUrl) {
        this.movieImageUrl = movieImageUrl;
    }

    public int getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(int movieScore) {
        this.movieScore = movieScore;
    }

    @Override
    public String toString() {
        return "MovieDetails{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", durationTime='" + durationTime + '\'' +
                ", description='" + description + '\'' +
                ", voiceLanguage='" + voiceLanguage + '\'' +
                ", subtitleLanguage='" + subtitleLanguage + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", cast=" + Arrays.toString(cast) +
                ", genre=" + Arrays.toString(genre) +
                ", movieImageUrl='" + movieImageUrl + '\'' +
                ", movieScore=" + movieScore +
                '}';
    }
}
