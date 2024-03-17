import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { addDateInReservation } from 'src/app/store/actions/reservation.action';

@Component({
  selector: 'app-choose-date',
  templateUrl: './choose-date.component.html',
  styleUrls: ['./choose-date.component.css']
})
export class ChooseDateComponent {
  constructor(private store:Store){}
  date:Date | undefined ;

  shooseDate()
  {
    if(this.date != undefined)
      this.store.dispatch(addDateInReservation({date:this.date}));
  }
}