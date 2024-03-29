import { Component } from '@angular/core';
import { BarberResp } from 'src/app/core/models/response/BarberResp.model';
import { BarberService } from 'src/app/core/services/barber.service';

@Component({
  selector: 'app-barber-profile',
  templateUrl: './barber-profile.component.html',
  styleUrls: ['./barber-profile.component.css']
})
export class BarberProfileComponent {
  barber:BarberResp={
    yearsOfExperience: "",
    id: 0,
    fullName: "",
    dateOfBirth: "",
    email: "",
    role: "",
    articles: [],
    services: [],
    rates: []
  }
  showRateForm:boolean=false
  showAllRates:boolean=false
  showClaimForm:boolean=false
  showCompetence:boolean=false
  constructor(private barberService:BarberService){}
  ngOnInit()
  {
    this.getBarber()
  }
  getBarber()
  {
    this.barberService.getOneBarber(5).subscribe((res)=>{
      this.barber = res 
      console.log(this.barber)
    })
  }
  closeModal(data: any) {
    this.showRateForm = false;
  }
  closeAllRateModal(data: any) {
    this.showAllRates = false;
  }
  closeClaimModal(data: any) {
    this.showClaimForm = false;
  }
  closeCompetenceModal(data: any) {
    this.showCompetence = false;
  }
}
