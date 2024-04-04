import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ReservationReq } from '../models/request/ReservatonReq.model';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getReservations(): Observable<any> {
    return this.http.get(`${this.apiUrl}/reservation`);
  }

  getReservationsByClient(id:number): Observable<any> {
    return this.http.get(`${this.apiUrl}/reservation/client/`+id);
  }

  getReservationsByBarber(id:number): Observable<any> {
    return this.http.get(`${this.apiUrl}/reservation/barber/`+id);
  }

  getOneReservation(id:number): Observable<any> {
    return this.http.get(`${this.apiUrl}/reservation/`+id);
  }

  postData(data: ReservationReq): Observable<any> {
    return this.http.post(`${this.apiUrl}/reservation`, data);
  }

  passedReservation(id: number): Observable<any> {
    return this.http.put(`${this.apiUrl}/reservation/passed-reservation/`+id, {});
  }
  notPassedReservation(id: number): Observable<any> {
    return this.http.put(`${this.apiUrl}/reservation/not-passed-reservation/`+id, {});
  }

  putData(data: ReservationReq,id:number): Observable<any> {
    return this.http.put(`${this.apiUrl}/reservation/`+id, data);
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/reservation/${id}`);
  }
}
