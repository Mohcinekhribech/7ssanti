import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { ServiceReq } from 'src/app/core/models/request/ServiceReq.model';
import { BarberResp } from 'src/app/core/models/response/BarberResp.model';
import { BarberService } from 'src/app/core/services/barber.service';
import {
  addEndTimeInReservation,
  addServicesReservation,
  addStartTimeInReservation,
  removeService,
} from 'src/app/store/actions/reservation.action';
import { selectReservation, selectservicesReserved } from 'src/app/store/selectors/reservation.selectors';

@Component({
  selector: 'app-choose-services',
  templateUrl: './choose-services.component.html',
  styleUrls: ['./choose-services.component.css'],
})
export class ChooseServicesComponent {
  constructor(
    private barberService: BarberService,
    private store: Store,
    private route: ActivatedRoute
  ) {}
  minutes:number=0
  startTime:String=''
  barber: BarberResp = {
    yearsOfExperience: '',
    articles: [],
    id: 0,
    fullName: '',
    dateOfBirth: '',
    email: '',
    role: 'Barber',
    services: [],
    rates: [],
    profilePic: '',
    competences: []
  };
  services: ServiceReq[] = [];
  shoosedServices: number[] = [];
  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.barberService
        .getOneBarber(params['id'])
        .subscribe((res) => (this.barber = res));
    });
    this.store.select(selectReservation).subscribe(reservation => {
      this.startTime = reservation.startTime
    })
  }
  shooseService(id: number, service: ServiceReq) {
    this.shoosedServices.push(id);
    this.services.push(service);
    this.minutes += service.timeIstimation;
    
  }
  valide() {

    this.store.dispatch(addEndTimeInReservation({endTime : this.addMinutesToTime(this.startTime,this.minutes)}))
     
    this.store.dispatch(
      addServicesReservation({ services: this.shoosedServices })
    );
    
  }
  removeService(id: number) {
    this.shoosedServices = this.shoosedServices.filter(
      (serviceId) => serviceId !== id
    );
    this.services = this.services.filter((service) => {
      if(service.id == id)
      {
        this.minutes -= service.timeIstimation
      }
      return service.id !== id
    });
    this.store.dispatch(removeService({ id: id }));
    
  }

  addMinutesToTime(time: String, minutesToAdd: number): String {
    const [hoursStr, minutesStr] = time.split(':');
    let hours = parseInt(hoursStr);
    let minutes = parseInt(minutesStr);

    minutes += minutesToAdd;

    hours += Math.floor(minutes / 60);
    minutes = minutes % 60;

    const newHours = hours.toString().padStart(2, '0');
    const newMinutes = minutes.toString().padStart(2, '0');

    return `${newHours}:${newMinutes}`;
  }
}
