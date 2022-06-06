import { Component, OnInit } from '@angular/core';
import { MoviesCardServiceService } from 'src/app/services/movies-card-service.service';
import { Moviecard } from '../../models/movie-card-model'

@Component({
  selector: 'app-movies-grid',
  templateUrl: './movies-grid.component.html',
  styleUrls: ['./movies-grid.component.css']
})
export class MoviesGridComponent implements OnInit {

  moviesFirst: Moviecard [];
  moviesSecond: Moviecard[];
  movies: Moviecard[];

  constructor(private MoviesCardServiceService: MoviesCardServiceService) { }

  ngOnInit(): void {

    this.MoviesCardServiceService.getAll().subscribe(data =>{
      this.movies = data;
    })


  }

}
