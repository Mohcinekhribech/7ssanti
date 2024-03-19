import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClaimReq } from '../models/request/ClaimReq.model';

@Injectable({
  providedIn: 'root',
})
export class ClaimService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getClaims(): Observable<any> {
    return this.http.get(`${this.apiUrl}/claim`);
  }

  getOneClaim(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/claim/` + id);
  }

  postData(data: ClaimReq): Observable<any> {
    return this.http.post(`${this.apiUrl}/claim`, data);
  }

  putData(data: ClaimReq, id: number): Observable<any> {
    return this.http.put(`${this.apiUrl}/claim/` + id, data);
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/claim/${id}`);
  }
}
