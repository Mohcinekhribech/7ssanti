import { Component } from '@angular/core';
import { RateResp } from 'src/app/core/models/response/RateResp.model';
import { RateService } from 'src/app/core/services/rate.service';

@Component({
  selector: 'app-all-rate',
  templateUrl: './all-rate.component.html',
  styleUrls: ['./all-rate.component.css']
})
export class AllRateComponent {
  constructor(private rateService:RateService){}

  rates:RateResp[]=[]

  ngOnInit()
  {
    this.getAllRates();
  }

  getAllRates()
  {
    this.rateService.getRates().subscribe(res =>{
      this.rates = res
    })
  }
  
}
