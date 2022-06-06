import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { MovieCinemaRoomComponent } from './components/movie-cinema-room/movie-cinema-room.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { PaymentComponent } from './components/payment/payment.component';

const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'movieDetails/:movieName/:movieCover/:movieTrailer/:description/:movieId', component: MovieCinemaRoomComponent },
  { path: 'payment', component: PaymentComponent },
  { path: '**', redirectTo: '', pathMatch: 'full' }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
