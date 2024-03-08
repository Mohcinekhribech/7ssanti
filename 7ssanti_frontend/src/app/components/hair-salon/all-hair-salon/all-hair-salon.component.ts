import { Component } from '@angular/core';
import { HairSalonResp } from 'src/app/core/models/response/HairSalonResp.model';
import { HairSalonService } from 'src/app/core/services/hair-salon.service';

@Component({
  selector: 'app-all-hair-salon',
  templateUrl: './all-hair-salon.component.html',
  styleUrls: ['./all-hair-salon.component.css']
})
export class AllHairSalonComponent {
  constructor(private hairSalonService:HairSalonService){
  }
  hairSalons:HairSalonResp[]=[]

  ngOnInit()
  {
    this.getAllhairSalons()
  }

  getAllhairSalons()
  {
    this.hairSalonService.getHairSalons()
    .subscribe(res =>{
      this.hairSalons = res
    })
  }
}
