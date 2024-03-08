import { Component } from '@angular/core';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent {
  step:number=0

  next()
  {
    this.step++
  }
  back()
  {
    this.step--
  }

}
