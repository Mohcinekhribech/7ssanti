import { Component } from '@angular/core';
import { ServiceReq } from 'src/app/core/models/request/ServiceReq.model';
import { ServiceResp } from 'src/app/core/models/response/ServiceResp.model';
import { ServiceService } from 'src/app/core/services/service.service';

@Component({
  selector: 'app-barber-services',
  templateUrl: './barber-services.component.html',
  styleUrls: ['./barber-services.component.css']
})
export class BarberServicesComponent {
  constructor(private serviceService:ServiceService){}
  showForm:boolean = false;
  service:ServiceReq= {
    id: 0,
    name: '',
    timeIstimation: 0,
    barber_id: 5,
    price: 0,
    description: ''
  }
  services:ServiceResp[]=[]

  ngOnInit()
  {
    this.getServices()
  }

  closeModal(data: any) {
    this.showForm = false;
  }
  postData()
  {
    this.serviceService.postData(this.service).subscribe(res => {
      console.log(res)
      this.showForm = false
    })
  }
  getServices()
  {
    this.serviceService.getServices().subscribe(res =>{
      this.services = res
    })
  }
}
