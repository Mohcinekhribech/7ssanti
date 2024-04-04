import { Component, Input } from '@angular/core';
import { RateReq } from 'src/app/core/models/request/RateReq.model';
import { UserResp } from 'src/app/core/models/response/UserResp.model';
import { RateService } from 'src/app/core/services/rate.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-rate-form',
  templateUrl: './rate-form.component.html',
  styleUrls: ['./rate-form.component.css']
})
export class RateFormComponent {
  @Input() user:UserResp | null = null
  @Input() barberId:number =0
  constructor(private rateService:RateService){}
  rateReq:RateReq = {
    id: 0,
    note: '',
    client_id: 0,
    barber_id: 0,
    rate: 0
  }

  ngOnInit()
  {
    this.rateReq.barber_id = this.barberId
    if(this.user)
      this.rateReq.client_id = this.user.id
  }

  postRate()
  {
    this.rateService.postData(this.rateReq).subscribe(res=>{
      Swal.fire({
        position: "center",
        icon: "success",
        title: "Your work has been saved",
        showConfirmButton: false,
        timer: 1500
      });
    })
  }
}
