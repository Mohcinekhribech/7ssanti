import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CompetenceReq } from '../models/request/CompetenceReq.model';

@Injectable({
  providedIn: 'root'
})
export class CompetenceService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getCompetences(): Observable<any> {
    return this.http.get(`${this.apiUrl}/competence`);
  }

  getOneCompetence(id:number): Observable<any> {
    return this.http.get(`${this.apiUrl}/competence/`+id);
  }

  postData(data: CompetenceReq): Observable<any> {
    return this.http.post(`${this.apiUrl}/competence`, data);
  }

  putData(data: CompetenceReq,id:number): Observable<any> {
    return this.http.put(`${this.apiUrl}/competence/`+id, data);
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/competence/${id}`);
  }
}
