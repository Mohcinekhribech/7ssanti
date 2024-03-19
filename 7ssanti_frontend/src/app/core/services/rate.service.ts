import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RateReq } from '../models/request/RateReq.model';

@Injectable({
  providedIn: 'root'
})
export class RateService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getRates(): Observable<any> {
    return this.http.get(`${this.apiUrl}/rate`);
  }

  getOneRate(id:number): Observable<any> {
    return this.http.get(`${this.apiUrl}/rate/`+id);
  }

  postData(data: RateReq): Observable<any> {
    return this.http.post(`${this.apiUrl}/rate`, data);
  }

  putData(data: RateReq,id:number): Observable<any> {
    return this.http.put(`${this.apiUrl}/rate/`+id, data);
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/rate/${id}`);
  }
}
