import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {from} from 'rxjs';
import { Moviecard } from '../../app/models/movie-card-model'



@Injectable({
  providedIn: 'root'
})
export class MoviesCardServiceService {

  constructor(public http: HttpClient) { }

  getAll(){
    return this.http.get<Moviecard[]>("http://localhost:8762/movieDetails/movieDetails/all");
  }
}
