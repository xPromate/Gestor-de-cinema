import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Ticket } from '../models/Ticket';
import { ThisReceiver } from '@angular/compiler';
import { tick } from '@angular/core/testing';

@Injectable({
  providedIn: 'root'
})
export class TicketServiceService {

  constructor(public http: HttpClient) { }

  saveTicket(ticket: Ticket){
    return this.http.post<any>("http://localhost:8762/tickets/tickets/takeTicket", ticket);
  }
}
