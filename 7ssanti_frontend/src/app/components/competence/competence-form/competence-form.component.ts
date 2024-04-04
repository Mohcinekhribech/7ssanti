import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CompetenceReq } from 'src/app/core/models/request/CompetenceReq.model';
import { CompetenceService } from 'src/app/core/services/competence.service';

@Component({
  selector: 'app-competence-form',
  templateUrl: './competence-form.component.html',
  styleUrls: ['./competence-form.component.css']
})
export class CompetenceFormComponent {
  constructor(private competenceService:CompetenceService,private route:ActivatedRoute){}
  competenceReq:CompetenceReq = {
    id: 0,
    name: '',
    description: '',
    barber_id: 0
  }
  ngOnInit()
  {
    this.route.params.subscribe(params => {
      this.competenceReq.barber_id = params['id'];
    })
  }

  posteCompetence()
  {
    this.competenceService.postData(this.competenceReq).subscribe(()=>{})
  }
}
