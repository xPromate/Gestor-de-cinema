import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/models/movie';
import { MovieCinemaRoomService } from 'src/app/services/movie-cinema-room.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Movieinfobody } from 'src/app/models/movieinfobody';
import { availability } from 'src/app/models/availability';
import { MovieInfoReserve } from 'src/app/models/MovieInfoReserve';

@Component({
  selector: 'app-movie-cinema-room',
  templateUrl: './movie-cinema-room.component.html',
  styleUrls: ['./movie-cinema-room.component.css'],
})
export class MovieCinemaRoomComponent implements OnInit {

  moviesRequest: Movie[];
  movieName: String;
  movies: Movie[];
  movieCoverUrl: String;
  movieTrailer: String;
  description: String;
  movieSelected: Movie;
  seatsSelectedX: number[];
  seatsSelectedY: number[];
  movieInfo: Movieinfobody;
  movieAvalability: availability;
  movieInfoReserve: MovieInfoReserve;
  res;
  lugaresStringX: String;
  lugaresStringY: String;
  movieId: String;
  reservationId: String;
  

  constructor(private MovieCinemaRoomService: MovieCinemaRoomService, private route: ActivatedRoute, private router: Router, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.movieId = this.route.snapshot.paramMap.get('movieId');
    this.movieName = this.route.snapshot.paramMap.get('movieName');
    this.movieCoverUrl = this.route.snapshot.paramMap.get('movieCover');
    this.movieTrailer = this.route.snapshot.paramMap.get('movieTrailer');
    this.description = this.route.snapshot.paramMap.get('description');
    

    this.MovieCinemaRoomService.getAllMovies().subscribe(data => {
      this.moviesRequest = data;
      this.movies = []

      for(var i = 0; i < this.moviesRequest.length; i++){
        if(this.moviesRequest[i].movieName == this.movieName){
          this.movies.push(this.moviesRequest[i]);
        }
      }
    })
  }

  open(content,m) {

    for(var i = 0; i < this.movies.length ; i++){
      if(this.movies[i] == m){
        this.movieSelected = this.movies[i];
        break;
      }
    }

    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result;

    for(var i = 0 ; i < 8 ; i++){
      for(var j = 0 ; j < 6 ; j++){
          if(this.movieSelected.cinemaRoom.seats[i][j].reservationId != ""){
            document.getElementById(i+""+j).className = "seat occupied";
          }
      }
    } 

    this.seatsSelectedX = [];
    this.seatsSelectedY = [];
    
  }

  onClick(n){
    if(document.getElementById(n).className == "seat selected" || document.getElementById(n).className == "seat occupied" ){
      alert("lugar indisponível");
    }else{
      document.getElementById(n).className = "seat selected";
      var x = n.charAt(0);
      var y = n.charAt(1);
      this.seatsSelectedX.push(x);
      this.seatsSelectedY.push(y);
    }
  }

  reserve(){
    this.movieInfo = new Movieinfobody();
  
    this.movieInfo.movieName = this.movieName;
    this.movieInfo.exhibitionDate = this.movieSelected.exhibitionDate;
    this.movieInfo.exhibitionHour = this.movieSelected.exhibitionHour;
    this.movieInfo.x = this.seatsSelectedX;
    this.movieInfo.y = this.seatsSelectedY;
    this.movieInfo.movieId = this.movieId;
    
    
    this.MovieCinemaRoomService.checkSeats(this.movieInfo).subscribe(data =>{
      this.movieAvalability = data;

      this.movieInfoReserve = new MovieInfoReserve();

      this.movieInfoReserve.eventId = this.movieAvalability.eventId;
      this.movieInfoReserve.x = this.movieAvalability.x;
      this.movieInfoReserve.y = this.movieAvalability.y;

      this.lugaresStringX = this.movieInfoReserve.x + "";
      this.lugaresStringY = this.movieInfoReserve.y + "";
      
      if(this.movieAvalability.canSeat){
        this.MovieCinemaRoomService.reserveSeats(this.movieInfoReserve).subscribe(data => {
          this.reservationId = data.reservationId;
          this.router.navigate(['/payment'], { queryParams: { movieName: this.movieInfo.movieName, movieDate: this.movieInfo.exhibitionDate, movieHour: this.movieInfo.exhibitionHour, movieX: this.lugaresStringX, movieY: this.lugaresStringY, numberOfSeats: this.movieInfoReserve.x.length, invoiceId: this.reservationId, movieId: this.movieInfo.movieId, eventId: this.movieAvalability.eventId}});
        });
      }
    });
  }
}
