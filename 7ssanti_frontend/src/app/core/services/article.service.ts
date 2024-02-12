import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ArticleReq } from '../models/request/ArticleReq.model';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getArticles(): Observable<any> {
    return this.http.get(`${this.apiUrl}/article`);
  }

  getOneArticle(id:number): Observable<any> {
    return this.http.get(`${this.apiUrl}/article/`+id);
  }

  postData(data: ArticleReq): Observable<any> {
    return this.http.post(`${this.apiUrl}/article`, data);
  }

  putData(data: ArticleReq,id:number): Observable<any> {
    return this.http.put(`${this.apiUrl}/article/`+id, data);
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/article/${id}`);
  }
}
