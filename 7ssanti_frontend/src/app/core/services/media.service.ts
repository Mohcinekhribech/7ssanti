import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MediaReq } from '../models/request/MediaReq.model';

@Injectable({
  providedIn: 'root'
})
export class MediaService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getMedias(): Observable<any> {
    return this.http.get(`${this.apiUrl}/media`);
  }

  getOneMedia(id:number): Observable<any> {
    return this.http.get(`${this.apiUrl}/media/`+id);
  }

  postData(data: MediaReq): Observable<any> {
    return this.http.post(`${this.apiUrl}/media`, data);
  }

  postAllData(data: MediaReq[]): Observable<any> {
    return this.http.post(`${this.apiUrl}/media/all`, data);
  }

  putData(data: MediaReq,id:number): Observable<any> {
    return this.http.put(`${this.apiUrl}/media/`+id, data);
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/media/${id}`);
  }
}
