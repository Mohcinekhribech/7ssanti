import { Component, Input } from '@angular/core';
import { ClaimReq } from 'src/app/core/models/request/ClaimReq.model';
import { UserResp } from 'src/app/core/models/response/UserResp.model';
import { ClaimService } from 'src/app/core/services/claim.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-claim-form',
  templateUrl: './claim-form.component.html',
  styleUrls: ['./claim-form.component.css']
})
export class ClaimFormComponent {
  @Input() user:UserResp | null =null
  constructor(private claimService:ClaimService){}
  claimReq:ClaimReq={
    id: 0,
    content: '',
    user_id: 0
  }
  ngOnInit()
  {
    if(this.user)
      this.claimReq.user_id = this.user?.id
  }

  postClaim()
  {
    this.claimService.postData(this.claimReq).subscribe(res =>{
      Swal.fire({
        position: "center",
        icon: "success",
        title: "Claim was sended",
        showConfirmButton: false,
        timer: 1500
      });
    })
  }
}
