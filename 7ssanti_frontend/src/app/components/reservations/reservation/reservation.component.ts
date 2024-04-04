import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { ReservationReq } from 'src/app/core/models/request/ReservatonReq.model';
import { UserResp } from 'src/app/core/models/response/UserResp.model';
import { AuthService } from 'src/app/core/services/auth.service';
import { ReservationService } from 'src/app/core/services/reservation.service';
import { ServiceService } from 'src/app/core/services/service.service';
import { addClientIdInReservation } from 'src/app/store/actions/reservation.action';
import { selectReservation, selectservicesReserved } from 'src/app/store/selectors/reservation.selectors';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent {
  step:number=0
  constructor(private store:Store,private reservationService:ReservationService,private authService:AuthService, private serviceService:ServiceService){
    
  }
  reservation:ReservationReq =  {
    id: 0,
    date: '',
    startTime: '',
    endTime: '',
    etat: 'PENDING',
    clientId: 0,
    price: 0
  }
  user:UserResp | null = null

  ngOnInit()
  {
    this.user = this.authService.getAuthUser()
    this.store.dispatch(addClientIdInReservation({id : this.user!=null ? this.user?.id:0}))
  }

  next()
  {
    switch (this.step) {
      case 0 : {
        this.store.select(selectReservation)
        .subscribe(reservation => {
          this.reservation.date = reservation.date
          this.reservation.startTime = reservation.startTime
          this.reservation.endTime = reservation.endTime
          if(reservation.date){
            this.reservation.date = reservation.date
            this.step++
          }
        })
      }
      break;
      case 1 : {
        this.store.select(selectReservation)
        .subscribe(reservation => {
          if(reservation.startTime){
            this.reservation.startTime = reservation.startTime
            this.step++
          }
        })
      }
      break;
      case 2 : {
        this.store.select(selectservicesReserved)
        .subscribe(services => {
          if(services.length>=1){
            this.step++
          }
        })
      }
      break;
      case 3 : {
        this.saveReservation();
      }

    }
  }
  back()
  {
    this.step--
  }

  saveReservation()
  {
    this.store.select(selectReservation).subscribe(reservation => {
      this.reservationService.postData(reservation).subscribe((reservation)=>{
        this.store.select(selectservicesReserved).subscribe(ids =>{

          for(let id of ids){
            this.serviceService.postServicesReserved(reservation.id,id).subscribe(()=>{})
          }

          Swal.fire({
            position: "center",
            icon: "success",
            title: "Your work has been saved",
            showConfirmButton: false,
            timer: 1500
          });
          
        })
      })
    })
  }

}