import { Component, Input } from '@angular/core';
import { ClientReq } from 'src/app/core/models/request/ClientReq.model';
import { ArticleResp } from 'src/app/core/models/response/ArticleResp.model';

@Component({
  selector: 'app-article-info-in-barber-profile',
  templateUrl: './article-info-in-barber-profile.component.html',
  styleUrls: ['./article-info-in-barber-profile.component.css']
})
export class ArticleInfoInBarberProfileComponent {
  @Input() article:ArticleResp={
    id: 0,
    description: "",
    barber: null,
    medias: [],
    likes: [],
    comments: []
  }
  exist:boolean = false
  showinfo:boolean = false
  findWithId() {
    this.article.likes.map((user: ClientReq) => {
      if (user.id == 4) {
        this.exist = true
      };
    });
  }
}
