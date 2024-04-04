import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { BarberResp } from 'src/app/core/models/response/BarberResp.model';
import { UserResp } from 'src/app/core/models/response/UserResp.model';
import { AuthService } from 'src/app/core/services/auth.service';
import { BarberService } from 'src/app/core/services/barber.service';
import { selectUser } from 'src/app/store/selectors/user.selectors';

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
    rates: [],
    profilePic: '',
    competences: []
  }
  showRateForm:boolean=false
  showAllRates:boolean=false
  showClaimForm:boolean=false
  showCompetence:boolean=false
  user:UserResp | null ={
    id: 0,
    fullName: '',
    dateOfBirth: '',
    email: '',
    role: '',
    profilePic: ''
  }
  ratesSum:number = 0
  barberId : number = 0;
  constructor(private barberService:BarberService,private authService:AuthService,private route: ActivatedRoute){}
  ngOnInit()
  {
    this.route.params.subscribe(params => {
      this.barberId = params['id'];
    })
    this.getBarber()
    this.user = this.authService.getAuthUser()
  }
  getBarber()
  {
    this.barberService.getOneBarber(this.barberId).subscribe((res)=>{
      this.barber = res 
      this.barber.rates.map(rate => {
        this.ratesSum += rate.rate
      })
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
