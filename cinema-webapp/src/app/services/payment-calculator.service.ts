import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PaymentInfo } from '../models/PaymentInfo';
import { FinalPayment } from '../models/FinalPayment';

@Injectable({
  providedIn: 'root'
})
export class PaymentCalculatorService {

  constructor(public http: HttpClient) { }

  calculatePrice(paymentInfo: PaymentInfo){
    return this.http.post<any>("http://localhost:8762/moviePrices/moviePrices/calculatePrice", paymentInfo);
  }

  makePayment(finalPayment: FinalPayment){
    return this.http.post<any>("http://localhost:8762/payment/payment/makePayment", finalPayment);
  }
}
