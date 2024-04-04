import { Component, Input } from '@angular/core';
import { ReservationReq } from 'src/app/core/models/request/ReservatonReq.model';

@Component({
  selector: 'app-confirm-reservation',
  templateUrl: './confirm-reservation.component.html',
  styleUrls: ['./confirm-reservation.component.css']
})
export class ConfirmReservationComponent {
  @Input() reservation : ReservationReq = {
    id: 0,
    date: '',
    startTime: '',
    endTime: '',
    etat: 'PENDING',
    clientId: 0,
    price: 0
  }
}
