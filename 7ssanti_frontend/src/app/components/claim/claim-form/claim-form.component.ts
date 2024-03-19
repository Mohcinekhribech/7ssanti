import { Component } from '@angular/core';
import { ClaimReq } from 'src/app/core/models/request/ClaimReq.model';
import { ClaimService } from 'src/app/core/services/claim.service';

@Component({
  selector: 'app-claim-form',
  templateUrl: './claim-form.component.html',
  styleUrls: ['./claim-form.component.css']
})
export class ClaimFormComponent {
  constructor(private claimService:ClaimService){}
  claimReq:ClaimReq={
    id: 0,
    content: '',
    user_id: 4
  }
  postClaim()
  {
    this.claimService.postData(this.claimReq).subscribe(res =>{
      
    })
  }
}
