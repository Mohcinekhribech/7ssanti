import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ServiceReq } from '../models/request/ServiceReq.model';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getServices(): Observable<any> {
    return this.http.get(`${this.apiUrl}/service`);
  }

  getOneService(id:number): Observable<any> {
    return this.http.get(`${this.apiUrl}/service/`+id);
  }

  postData(data: ServiceReq): Observable<any> {
    return this.http.post(`${this.apiUrl}/service`, data);
  }

  postServicesReserved(reservationId: number,serviceId:number): Observable<any> {
    return this.http.post(`${this.apiUrl}/reserve/service/${reservationId}/${serviceId}`, {});
  }

  putData(data: ServiceReq,id:number): Observable<any> {
    return this.http.put(`${this.apiUrl}/service/`+id, data);
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/service/${id}`);
  }
}
