import { Component } from '@angular/core';
import { ReservationResp } from 'src/app/core/models/response/ReservationResp.model';
import { ReservationService } from 'src/app/core/services/reservation.service';

@Component({
  selector: 'app-all-my-reservations',
  templateUrl: './all-my-reservations.component.html',
  styleUrls: ['./all-my-reservations.component.css']
})
export class AllMyReservationsComponent {
  constructor(private reservationService: ReservationService){}
  reservations:ReservationResp[]=[]
  ngOnInit()
  {
    this.getAllReservations()
  }
  getAllReservations()
  {
    this.reservationService.getReservationsByClient(4).subscribe(res => {
      this.reservations = res
    })
  }
  passedReservation(id:number)
  {
    this.reservationService.passedReservation(id).subscribe(res => {
      if(res)
      {
        this.getAllReservations();
      }
    })
  }
  notPassedReservation(id:number)
  {

  }
}
