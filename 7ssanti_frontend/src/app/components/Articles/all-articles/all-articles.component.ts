import { Component } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { ArticleResp } from 'src/app/core/models/response/ArticleResp.model';
import { UserResp } from 'src/app/core/models/response/UserResp.model';
import { AuthService } from 'src/app/core/services/auth.service';
import { fetchArticle } from 'src/app/store/actions/article.action';
import { selectArticles } from 'src/app/store/selectors/article.selectors';

@Component({
  selector: 'app-all-articles',
  templateUrl: './all-articles.component.html',
  styleUrls: ['./all-articles.component.css']
})
export class AllArticlesComponent {
  constructor(private store:Store,private authService:AuthService) {}
  articles:ArticleResp[]=[]
  user:UserResp | null = {
    id: 0,
    fullName: '',
    dateOfBirth: '',
    email: '',
    role: '',
    profilePic: ''
  }
  ngOnInit()
  {
    this.getData()
    this.authService.getAuthUser() ? this.user = this.authService.getAuthUser() : null 
  }
  getData() {
    this.store.dispatch(fetchArticle())
    setTimeout(() => {
      this.store.pipe(select(selectArticles)).subscribe(articles => {
        console.log('articles:', articles);
        this.articles = articles
      });
    }, 1000);
    // this.quizService.getSomeData(page).subscribe(
    //   data => {
    //     this.quizs = data.content  
    //     console.log(this.quizs)
    //     this.totalPages = data.totalPages
    //   }
    // );
  }
}
