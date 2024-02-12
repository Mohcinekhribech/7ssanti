import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommentReq } from 'src/app/core/models/request/CommentReq.model';
import { ArticleResp } from 'src/app/core/models/response/ArticleResp.model';
import { CommentResp } from 'src/app/core/models/response/CommentResp.model';
import { CommentService } from 'src/app/core/services/comment.service';

@Component({
  selector: 'app-article-info',
  templateUrl: './article-info.component.html',
  styleUrls: ['./article-info.component.css']
})
export class ArticleInfoComponent {
  @Output() closeEvent = new EventEmitter<boolean>();
  @Input() showform:boolean = false
  @Input() article:ArticleResp = {
    id: 0,
    description: "",
    barber: null,
    medias: [],
    likes: [],
    comments: []
  }
  comments : CommentResp[]=[]
  comment:CommentReq={
    id: 0,
    content: "",
    article_id: 0,
    client_id: 4
  }
  constructor(private commentService:CommentService){}
  ngOnInit()
  {
    this.comment.article_id = this.article.id
    this.comments.push(...this.article.comments)
  }
  closeModalSendToParent()
  {
      this.closeEvent.emit(false) ;
  }
  postComment() {
    this.commentService.postData(this.comment).subscribe(
      (res:CommentResp) => {
        this.comments.push(res)
      },
      (err) => {
        console.error('Error occurred while posting comment:', err);
      }
    );
  }
  closeModal(closed:any)
  {
    this.closeModalSendToParent()
    this.showform = false
  }
}
