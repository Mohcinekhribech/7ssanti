import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { selectReservation, selectservicesReserved } from 'src/app/store/selectors/reservation.selectors';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent {
  step:number=0
  constructor(private store:Store){}

  next()
  {
    switch (this.step) {
      case 0 : {
        this.store.select(selectReservation)
        .subscribe(reservation => {
          console.log(reservation)
          if(reservation.date){
            this.step++
          }
        })
      }
      break;
      case 1 : {
        this.store.select(selectReservation)
        .subscribe(reservation => {
          if(reservation.startTime){
            this.step++
          }
        })
      }
      break;
      case 2 : {
        this.store.select(selectservicesReserved)
        .subscribe(services => {
          if(services.length>1){
            this.step++
          }
        })
      }
      break;

    }
  }
  back()
  {
    this.step--
  }

}
