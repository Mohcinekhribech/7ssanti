import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CompetenceReq } from 'src/app/core/models/request/CompetenceReq.model';
import { UserResp } from 'src/app/core/models/response/UserResp.model';
import { AuthService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-competence',
  templateUrl: './competence.component.html',
  styleUrls: ['./competence.component.css']
})
export class CompetenceComponent {
  @Input() competences : CompetenceReq[] = []
  showCompetenceForm:boolean = false
  constructor(private authService:AuthService, private route:ActivatedRoute){}
  user : UserResp | null = {
    id: 0,
    fullName: '',
    dateOfBirth: '',
    email: '',
    role: '',
    profilePic: ''
  }
  barberId:number = 0
  ngOnInit()
  {
    this.route.params.subscribe(params => {
      this.barberId = params['id'];
    })
    this.user = this.authService.getAuthUser()
  }
}
