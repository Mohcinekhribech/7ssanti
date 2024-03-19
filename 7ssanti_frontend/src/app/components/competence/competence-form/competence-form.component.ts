import { Component } from '@angular/core';
import { CompetenceReq } from 'src/app/core/models/request/CompetenceReq.model';
import { CompetenceService } from 'src/app/core/services/competence.service';

@Component({
  selector: 'app-competence-form',
  templateUrl: './competence-form.component.html',
  styleUrls: ['./competence-form.component.css']
})
export class CompetenceFormComponent {
  constructor(private competenceService:CompetenceService){}
  competenceReq:CompetenceReq = {
    id: 0,
    name: '',
    description: '',
    barber_id: 0
  }

  posteCompetence()
  {
    this.competenceService.postData(this.competenceReq).subscribe(()=>{})
  }
}
