import { Component } from '@angular/core';
import { ReservationResp } from 'src/app/core/models/response/ReservationResp.model';
import { UserResp } from 'src/app/core/models/response/UserResp.model';
import { AuthService } from 'src/app/core/services/auth.service';
import { ReservationService } from 'src/app/core/services/reservation.service';

@Component({
  selector: 'app-all-my-reservations',
  templateUrl: './all-my-reservations.component.html',
  styleUrls: ['./all-my-reservations.component.css']
})
export class AllMyReservationsComponent {
  constructor(private reservationService: ReservationService , private authService:AuthService){}
  reservations:ReservationResp[]=[]
  user:UserResp | null ={
    id: 0,
    fullName: '',
    profilePic: '',
    dateOfBirth: '',
    email: '',
    role: ''
  }
  ngOnInit()
  {
    this.user = this.authService.getAuthUser()
    this.getAllReservations()
  }
  getAllReservations()
  {
    if(this.user?.role == "Client"){
      this.reservationService.getReservationsByClient(this.user.id).subscribe(res => {
        this.reservations = res
      })
    }else if(this.user?.role == 'Barber')
    {
      this.reservationService.getReservationsByBarber(this.user.id).subscribe(res => {
        this.reservations = res
      })
    }
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
