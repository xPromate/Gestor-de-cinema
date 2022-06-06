import { CinemaRoom } from './cinema-room'

export class Movie {
	id: String;
    movieName: String;
    exhibitionDate: String;
    exhibitionHour: String;
    cinemaRoom: CinemaRoom;
    isFull: Boolean;
}