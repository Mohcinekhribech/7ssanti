import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ServiceReq } from 'src/app/core/models/request/ServiceReq.model';
import { ServiceResp } from 'src/app/core/models/response/ServiceResp.model';
import { UserResp } from 'src/app/core/models/response/UserResp.model';
import { AuthService } from 'src/app/core/services/auth.service';
import { ServiceService } from 'src/app/core/services/service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-barber-services',
  templateUrl: './barber-services.component.html',
  styleUrls: ['./barber-services.component.css']
})
export class BarberServicesComponent {
  constructor(private serviceService:ServiceService,private route:ActivatedRoute,private authService:AuthService){}
  showForm:boolean = false;
  service:ServiceReq= {
    id: 0,
    name: '',
    timeIstimation: 0,
    barber_id: 0,
    price: 0,
    description: ''
  }
  user : UserResp | null = null;
  services:ServiceResp[]=[]

  ngOnInit()
  {
    this.authService.getAuthUser() ? this.user = this.authService.getAuthUser() : null 
    this.route.params.subscribe(params => {
      this.service.barber_id = params['id'];
    })
    this.getServices()
  }

  closeModal(data: any) {
    this.showForm = false;
  }
  postData()
  {
    this.serviceService.postData(this.service).subscribe(res => {
      this.showForm = false
      Swal.fire({
        position: "center",
        icon: "success",
        title: "Your work has been saved",
        showConfirmButton: false,
        timer: 1500
      });
      this.getServices();
    })
  }
  getServices()
  {
    this.serviceService.getServices().subscribe(res =>{
      this.services = res
    })
  }
}
