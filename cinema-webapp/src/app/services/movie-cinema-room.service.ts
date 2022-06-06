import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Movie } from '../models/movie';
import {Movieinfobody} from '../models/movieinfobody';
import { share } from 'rxjs/operators';
import { availability } from '../models/availability';
import { MovieInfoReserve } from '../models/MovieInfoReserve';

const httpOptions = {
  headers: new HttpHeaders ({
    'Content-type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})
export class MovieCinemaRoomService {

  constructor(public http: HttpClient) { }

  getAllMovies(){
    return this.http.get<Movie[]>("http://localhost:8762/movies/movies/all");
  }

  checkSeats(movieinfobody: Movieinfobody){
    return this.http.post<availability>("http://localhost:8762/checkMovieAvailability/checkMovieAvailability/availability",movieinfobody,{headers: httpOptions.headers});
  }

  reserveSeats(movieinforeserve: MovieInfoReserve){
    return this.http.post<MovieInfoReserve>("http://localhost:8762/manager/manager/makeReserve",movieinforeserve,{headers: httpOptions.headers});
  }
}
