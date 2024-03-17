import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { ServiceReq } from 'src/app/core/models/request/ServiceReq.model';
import { BarberResp } from 'src/app/core/models/response/BarberResp.model';
import { BarberService } from 'src/app/core/services/barber.service';
import { addServicesReservation, removeService } from 'src/app/store/actions/reservation.action';
import { selectservicesReserved } from 'src/app/store/selectors/reservation.selectors';

@Component({
  selector: 'app-choose-services',
  templateUrl: './choose-services.component.html',
  styleUrls: ['./choose-services.component.css']
})
export class ChooseServicesComponent {
  constructor(private barberService:BarberService,private store:Store){}
  barber:BarberResp={
    yearsOfExperience: "",
    articles: [],
    id: 0,
    fullName: "",
    dateOfBirth: "",
    email: "",
    role: "Barber",
    services: []
  }
  services:ServiceReq[]=[];
  shoosedServices:number[]=[]
  ngOnInit()
  {
    this.barberService.getOneBarber(5).subscribe(res => this.barber = res)
  }
  shooseService(id:number,service:ServiceReq)
  {
    this.shoosedServices.push(id)
    this.services.push(service)
  }
  valide()
  {
    this.store.dispatch(addServicesReservation({services: this.shoosedServices}))
  }
  removeService(id:number)
  {
    this.shoosedServices= this.shoosedServices.filter(serviceId => serviceId !== id)
    this.services = this.services.filter(service => service.id !== id)
    this.store.dispatch(removeService({id: id}))

  }
}