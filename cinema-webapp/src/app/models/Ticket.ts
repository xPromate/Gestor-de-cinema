import { Seat } from "./seat";

export class Ticket {
    numberOfSeats: Number;
    roomName: String;
    localSeats: Seat[][];
    movieName: String;
    dateTime: String;
    reservationId: String;
}