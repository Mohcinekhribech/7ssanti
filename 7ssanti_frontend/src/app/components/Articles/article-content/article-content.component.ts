import { Component, Input } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { ClientReq } from 'src/app/core/models/request/ClientReq.model';
import { ArticleResp } from 'src/app/core/models/response/ArticleResp.model';
import { LikesService } from 'src/app/core/services/likes.service';
import { updateArticle } from 'src/app/store/actions/article.action';
import { selectArticleById } from 'src/app/store/selectors/article.selectors';

@Component({
  selector: 'app-article-content',
  templateUrl: './article-content.component.html',
  styleUrls: ['./article-content.component.css'],
})
export class ArticleContentComponent {
  @Input() article: ArticleResp  = {
    id: 0,
    description: '',
    barber: null,
    medias: [],
    likes: [],
    comments: []
  };
  client:ClientReq={
    dateOfBirth: "2020-02-11",
    email: "stringg",
    fullName: "string",
    id: 4,
    password:"stringstt",
    registrationDate: "2020-02-11",
    role: "Client"
  }
  likes:number=0
  exist: boolean = false;
  ngOnInit() {
    this.findWithId();
    this.likes = this.article.likes.length
  }
  constructor(private likeService: LikesService, private store:Store) {}
  showed: boolean = false;

  findWithId() {
    this.article.likes.map((user: ClientReq) => {
      if (user.id == 4) {
        this.exist = true
        this.client = user
      };
    });
  }

  addLike() {
    this.likeService.addLike(this.article.id, 4).subscribe(() => {
      this.exist = true;
      ++this.likes
      if (!this.article.likes.includes(this.client)) {
        this.article.likes.push(this.client);
      }
      // this.store.dispatch(updateArticle({ id: this.article.id, article: this.article }));
    });
  }
  
  removeLike() {
    
    this.likeService.deleteLike(this.article.id, 4).subscribe(()=>{
      this.exist = false
      let index = this.article.likes.findIndex((client)=> client.id == this.client.id )
      this.article.likes.slice(index,1)
      --this.likes
      // this.store.dispatch(updateArticle({id:this.article.id, article : this.article}))
    });
  }

  showArticle() {
    this.showed = true;
  }
  closeModal(closed: any) {
    this.showed = false;
  }
}
