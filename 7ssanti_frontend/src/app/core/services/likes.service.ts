import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LikesService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  addLike(article_id:number,client_id:number): Observable<any> {
    return this.http.post(`${this.apiUrl}/like/${article_id}/${client_id}`,{});
  }

  deleteLike(article_id:number,client_id:number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/like/${article_id}/${client_id}`);
  }
}
