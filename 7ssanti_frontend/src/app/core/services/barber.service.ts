import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BarberReq } from '../models/request/BarberReq.model';

@Injectable({
  providedIn: 'root'
})
export class BarberService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getBarbers(): Observable<any> {
    return this.http.get(`${this.apiUrl}/barber`);
  }

  getOneBarber(id:number): Observable<any> {
    return this.http.get(`${this.apiUrl}/barber/`+id);
  }

  postData(data: BarberReq): Observable<any> {
    return this.http.post(`${this.apiUrl}/barber`, data);
  }

  putData(data: BarberReq,id:number): Observable<any> {
    return this.http.put(`${this.apiUrl}/barber/`+id, data);
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/barber/${id}`);
  }
}
