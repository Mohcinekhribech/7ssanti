import { Component } from '@angular/core';
import { BarberResp } from 'src/app/core/models/response/BarberResp.model';
import { BarberService } from 'src/app/core/services/barber.service';

@Component({
  selector: 'app-barbers',
  templateUrl: './barbers.component.html',
  styleUrls: ['./barbers.component.css']
})
export class BarbersComponent {
  constructor(private barberService: BarberService) {}
  barbers:BarberResp[] =[];
  showCompetence : boolean = false;
  showAllRates : boolean = false;
  id:number = 0;

  ngOnInit() {
    this.getData();
  }

  getData() {
    this.barberService.getBarbers().subscribe(
      data => {
        this.barbers = data
      }
    );
  }
  closeCompetenceModal(data: any) {
    this.showCompetence = false;
  }
  closeAllRateModal(data: any) {
    this.showAllRates = false;
  }
}
