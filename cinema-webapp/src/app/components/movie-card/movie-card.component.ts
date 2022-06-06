import { Component, OnInit } from '@angular/core';
import { MoviesCardServiceService } from 'src/app/services/movies-card-service.service';
import { Moviecard } from '../../models/movie-card-model'

@Component({
  selector: 'app-movie-card',
  templateUrl: './movie-card.component.html',
  styleUrls: ['./movie-card.component.css']
})
export class MovieCardComponent implements OnInit {

  movies: Moviecard [];

  constructor(private MoviesCardServiceService: MoviesCardServiceService) { }

  ngOnInit(): void {

    
    this.MoviesCardServiceService.getAll().subscribe(data =>{
        this.movies = data;
    })
  
  }

}
