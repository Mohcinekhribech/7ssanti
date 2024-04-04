import { Component, Input } from '@angular/core';
import { CompetenceReq } from 'src/app/core/models/request/CompetenceReq.model';

@Component({
  selector: 'app-show-competence',
  templateUrl: './show-competence.component.html',
  styleUrls: ['./show-competence.component.css']
})
export class ShowCompetenceComponent {
  @Input() competences : CompetenceReq [] =[] 
}
