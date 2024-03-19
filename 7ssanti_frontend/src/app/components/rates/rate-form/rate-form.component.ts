import { Component } from '@angular/core';
import { RateReq } from 'src/app/core/models/request/RateReq.model';
import { RateService } from 'src/app/core/services/rate.service';

@Component({
  selector: 'app-rate-form',
  templateUrl: './rate-form.component.html',
  styleUrls: ['./rate-form.component.css']
})
export class RateFormComponent {
  constructor(private rateService:RateService){}
  rateReq:RateReq = {
    id: 0,
    note: '',
    client_id: 4,
    barber_id: 5,
    rate: 0
  }

  postRate()
  {
    this.rateService.postData(this.rateReq).subscribe(res=>{})
  }
}
