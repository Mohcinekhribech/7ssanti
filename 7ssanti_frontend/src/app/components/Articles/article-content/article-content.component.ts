import { Component, Input } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { ClientReq } from 'src/app/core/models/request/ClientReq.model';
import { ArticleResp } from 'src/app/core/models/response/ArticleResp.model';
import { UserResp } from 'src/app/core/models/response/UserResp.model';
import { AuthService } from 'src/app/core/services/auth.service';
import { LikesService } from 'src/app/core/services/likes.service';

@Component({
  selector: 'app-article-content',
  templateUrl: './article-content.component.html',
  styleUrls: ['./article-content.component.css'],
})
export class ArticleContentComponent {
  @Input() user : UserResp |null = {
    id: 0,
    fullName: '',
    profilePic: '',
    dateOfBirth: '',
    email: '',
    role: ''
  }
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
    id: 0,
    password: "stringstt",
    registrationDate: "2020-02-11",
    role: "Client",
    profilePic: ''
  }
  mediaStep:number=0
  likes:number=0
  exist: boolean = false;
  ngOnInit() {
    this.client.id = this.user ? this.user.id : 0
    this.findWithId();
    this.likes = this.article.likes.length
  }
  constructor(private likeService: LikesService, private authService:AuthService) {}
  showed: boolean = false;

  nextMedia()
  {
    if(this.article.medias.length-1 > this.mediaStep )
       this.mediaStep++;
    else this.mediaStep = 0
  }

  backMedia()
  {
    if(this.article.medias.length-1 <= 0 )
       this.mediaStep--;
    else this.mediaStep = 0
  }

  findWithId() {
    this.article.likes.map((user: ClientReq) => {
      if (user.id == this.client.id) {
        this.exist = true
        this.client = user
      };
    });
  }

  addLike() {
    this.likeService.addLike(this.article.id, this.client.id).subscribe((res) => {
      console.log(res)
      this.exist = true;
      ++this.likes
      if (!this.article.likes.includes(this.client)) {
        this.article.likes.push(this.client);
      }
    });
  }
  
  removeLike() {
    
    this.likeService.deleteLike(this.article.id, 4).subscribe(()=>{
      this.exist = false
      let index = this.article.likes.findIndex((client)=> client.id == this.client.id )
      this.article.likes.slice(index,1)
      --this.likes
    });
  }

  showArticle() {
    this.showed = true;
  }
  closeModal(closed: any) {
    this.showed = false;
  }
}
