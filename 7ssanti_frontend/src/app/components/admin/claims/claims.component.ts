import { Component } from '@angular/core';
import { ClaimReq } from 'src/app/core/models/request/ClaimReq.model';
import { ClaimResp } from 'src/app/core/models/response/ClaimResp.model';
import { ClaimService } from 'src/app/core/services/claim.service';

@Component({
  selector: 'app-claims',
  templateUrl: './claims.component.html',
  styleUrls: ['./claims.component.css']
})
export class ClaimsComponent {
  constructor(private claimService: ClaimService) {}
  claims:ClaimResp[] =[];
  isShowAddForm : boolean = false;
  isShowUpdateForm : boolean = false;
  id:number = 0;

  ngOnInit() {
    this.getData();
  }

  getData() {
    this.claimService.getClaims().subscribe(
      data => {
        this.claims = data
      }
    );
  }
}
