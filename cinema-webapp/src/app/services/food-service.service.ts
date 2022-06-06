import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FoodInfo } from '../models/FoodInfo';

@Injectable({
  providedIn: 'root'
})
export class FoodServiceService {

  constructor(public http: HttpClient) { }

  foodAvailability(foodInfo: FoodInfo){
    return this.http.post<any>("http://localhost:8762/checkFoodAvailability/checkFoodAvailability/availability", foodInfo);
  }

  reserveFood(foodInfo: FoodInfo){
    return this.http.post<any>("http://localhost:8762/foodManager/foodManager/makeFoodReservation", foodInfo);
  }
}