import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CommentReq } from '../models/request/CommentReq.model';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getComments(): Observable<any> {
    return this.http.get(`${this.apiUrl}/comment`);
  }

  getOneComment(id:number): Observable<any> {
    return this.http.get(`${this.apiUrl}/comment/`+id);
  }

  postData(data: CommentReq): Observable<any> {
    return this.http.post(`${this.apiUrl}/comment`, data);
  }

  putData(data: CommentReq,id:number): Observable<any> {
    return this.http.put(`${this.apiUrl}/comment/`+id, data);
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/comment/${id}`);
  }
}
