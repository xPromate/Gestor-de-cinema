import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FinalPayment } from 'src/app/models/FinalPayment';
import { FoodInfo } from 'src/app/models/FoodInfo';
import { PaymentInfo } from 'src/app/models/PaymentInfo';
import { FoodServiceService } from 'src/app/services/food-service.service';
import { PaymentCalculatorService } from 'src/app/services/payment-calculator.service';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import * as html2pdf from "html2pdf.js";
import { TicketServiceService } from 'src/app/services/ticket-service.service';
import { Ticket } from 'src/app/models/Ticket';
import { MovieInfoReserve } from 'src/app/models/MovieInfoReserve';
import { MovieCinemaRoomService } from 'src/app/services/movie-cinema-room.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  movieName: String;
  movieDate: String;
  movieHour: String;
  movieX: String;
  movieY: String;
  numberOfSeats: String;
  myDate: Date;
  totalPrice: Number;
  totalPriceVat: Number;
  finalPrice: Number;
  foodArray: String[];
  precoTotal: Number;
  foodAvailability: any;
  foodInfo: FoodInfo;
  invoiceId: String;
  paymentInfo: PaymentInfo;
  movieId: String;
  finalPayment: FinalPayment;
  buttonDisabled: Boolean;
  ticket: Ticket;
  makeMoviePaid: MovieInfoReserve;
  intSeatsX: Number[];
  intSeatsY: Number[];
  eventId: String;

  constructor(private route: ActivatedRoute, private router: Router, private foodService: FoodServiceService, private priceService: PaymentCalculatorService, private modalService: NgbModal, private ticketService: TicketServiceService, private MovieCinemaRoomService: MovieCinemaRoomService) { }

  ngOnInit(): void {
    this.foodInfo = new FoodInfo();
    this.paymentInfo = new PaymentInfo();
    this.finalPayment = new FinalPayment();
    this.buttonDisabled = true;
    this.ticket = new Ticket();
    this.makeMoviePaid = new MovieInfoReserve();

    this.route.queryParams.subscribe( params => {
      this.movieName = params['movieName'];
      this.movieDate = params['movieDate'];
      this.movieHour = params['movieHour'];
      this.movieX = params['movieX'];
      this.movieY = params['movieY'];
      this.numberOfSeats = params['numberOfSeats']
      this.invoiceId = params['invoiceId'];
      this.movieId = params['movieId'];
      this.eventId = params['eventId'];
    })

    this.finalPrice = 3.5;

    this.paymentInfo.numberOfTickets = +this.numberOfSeats;
    this.paymentInfo.movieId = this.movieId;
    this.paymentInfo.reserveId = this.invoiceId;
    this.paymentInfo.nachos = 0;
    this.paymentInfo.popcorn = 0;
    this.paymentInfo.cocaCola = 0;
    this.paymentInfo.iceTeaLemon = 0;
    this.paymentInfo.sprite = 0;
    this.paymentInfo.water = 0;

    var arrayX = this.movieX.split(",");
    var arrayY = this.movieY.split(",");

    this.intSeatsX = [];
    this.intSeatsY = [];
      
    for(var i = 0; i < arrayX.length; i++){
      this.intSeatsX.push(+arrayX[i]);
    }

    for(var i = 0; i < arrayY.length; i++){
      this.intSeatsY.push(+arrayY[i]);
    }

    this.priceService.calculatePrice(this.paymentInfo).subscribe(data => {
      this.precoTotal = data.price;
    })

    this.myDate = new Date();    
  }

  open(content) {
    if(!this.buttonDisabled){
      this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result;
    }
  }

  onItemChange(value){
    var table: HTMLTableElement = <HTMLTableElement> document.getElementById("addFood");

    var row = table.insertRow(0);

    if(value == "Nachos"){
      this.foodInfo.nachosKg = 0.5;
      this.paymentInfo.nachos = 1;

      row.innerHTML += '<tr><td class="center">' + table.rows.length + '</td></tr>';
      row.innerHTML += '<td class="left strong">' + value + '</td></tr>';
      row.innerHTML += '<td class="left">' + '</td></tr>';
      row.innerHTML += '<td class="right">' + 3 + '</td></tr>';
      row.innerHTML += '<td class="center">' + 1 + '</td></tr>';
    }

    if(value == "Pipocas"){
      this.foodInfo.popcornKg = 0.5;
      this.paymentInfo.popcorn = 1;

      row.innerHTML += '<tr><td class="center">' + table.rows.length + '</td></tr>';
      row.innerHTML += '<td class="left strong">' + value + '</td></tr>';
      row.innerHTML += '<td class="left">' + '</td></tr>';
      row.innerHTML += '<td class="right">' + 3 + '</td></tr>';
      row.innerHTML += '<td class="center">' + 1 + '</td></tr>';
    }
    
    if(value == "Cocacola"){
      this.foodInfo.cocaColaLiters = 0.25;
      this.paymentInfo.cocaCola = 1;

      row.innerHTML += '<tr><td class="center">' + table.rows.length + '</td></tr>';
      row.innerHTML += '<td class="left strong">' + value + '</td></tr>';
      row.innerHTML += '<td class="left">' + '</td></tr>';
      row.innerHTML += '<td class="right">' + 1.5 + '</td></tr>';
      row.innerHTML += '<td class="center">' + 1 + '</td></tr>';
    }

    if(value == "Icetea"){
      this.foodInfo.lemonIceTeaLiters = 0.25;
      this.paymentInfo.iceTeaLemon = 1;

      row.innerHTML += '<tr><td class="center">' + table.rows.length + '</td></tr>';
      row.innerHTML += '<td class="left strong">' + value + '</td></tr>';
      row.innerHTML += '<td class="left">' + '</td></tr>';
      row.innerHTML += '<td class="right">' + 1.5 + '</td></tr>';
      row.innerHTML += '<td class="center">' + 1 + '</td></tr>';
    }
    
    if(value == "Sprite"){
      this.foodInfo.spriteLiters = 0.25;
      this.paymentInfo.sprite = 1;

      row.innerHTML += '<tr><td class="center">' + table.rows.length + '</td></tr>';
      row.innerHTML += '<td class="left strong">' + value + '</td></tr>';
      row.innerHTML += '<td class="left">' + '</td></tr>';
      row.innerHTML += '<td class="right">' + 1.5 + '</td></tr>';
      row.innerHTML += '<td class="center">' + 1 + '</td></tr>';
    }

    if(value == "Agua"){
      this.foodInfo.waterLiters = 0.25;
      this.paymentInfo.water = 1;

      row.innerHTML += '<tr><td class="center">' + table.rows.length + '</td></tr>';
      row.innerHTML += '<td class="left strong">' + value + '</td></tr>';
      row.innerHTML += '<td class="left">' + '</td></tr>';
      row.innerHTML += '<td class="right">' + 1.5 + '</td></tr>';
      row.innerHTML += '<td class="center">' + 1 + '</td></tr>';
    }

    this.priceService.calculatePrice(this.paymentInfo).subscribe(data => {
      this.precoTotal = data.price;
    })
 }

 finalizarCompra(){
   this.finalPayment.userId = 99999;
   this.finalPayment.nif = 99999;
   this.finalPayment.value = this.precoTotal;
   this.finalPayment.numberOfTickets = +this.numberOfSeats;
   this.finalPayment.eventId = this.movieId;
   this.finalPayment.movieName = this.movieName;
   this.finalPayment.movieId = this.movieId;
   this.finalPayment.reserveId = this.invoiceId;

   this.foodService.foodAvailability(this.foodInfo).subscribe(data => {
      this.foodAvailability = data;

      if(this.foodAvailability.available){
        this.foodService.reserveFood(this.foodInfo).subscribe();
        this.priceService.makePayment(this.finalPayment).subscribe();
        this.buttonDisabled = false;        

        this.makeMoviePaid.eventId = this.eventId;
        this.makeMoviePaid.x = this.intSeatsX;
        this.makeMoviePaid.y = this.intSeatsY;

        this.MovieCinemaRoomService.reserveSeats(this.makeMoviePaid).subscribe();

        alert("Reserva efetuada com sucesso.")
      }
   });
 }

 gerarTicket(){
    if(this.buttonDisabled){
      alert("Finalize o pagamento primeiro!");
    } else {
      this.ticket.movieName = this.movieName;
      this.ticket.dateTime = this.movieDate + "" + this.movieHour;
      this.ticket.reservationId = this.invoiceId;
      this.ticket.roomName = "";
      this.ticket.localSeats = null;
      this.ticket.numberOfSeats = +this.numberOfSeats;

      this.ticketService.saveTicket(this.ticket).subscribe();
    }
 }

 exportToPdf(){
   const options = {
     filename: "ticket.pdf",
     image: { type: 'jpeg' },
     html2canvas: {},
     jsPDF: { orientation: 'portrait'}
   };

   const content: Element = document.getElementById('ticketId');

   html2pdf().from(content).set(options).save();

   this.router.navigate(['']);
 }
}
