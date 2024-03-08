import { Component } from '@angular/core';
import { BarberResp } from 'src/app/core/models/response/BarberResp.model';
import { BarberService } from 'src/app/core/services/barber.service';

@Component({
  selector: 'app-all-barbers',
  templateUrl: './all-barbers.component.html',
  styleUrls: ['./all-barbers.component.css']
})
export class AllBarbersComponent {
  constructor(private barberService:BarberService){
  }
  barbers:BarberResp[]=[]

  ngOnInit()
  {
    this.getAllBarbers()
  }

  getAllBarbers()
  {
    this.barberService.getBarbers()
    .subscribe(res =>{
      this.barbers = res
    })
  }
}
