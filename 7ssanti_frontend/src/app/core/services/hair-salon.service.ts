import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HairSalonReq } from '../models/request/HairSalonReq.model';

@Injectable({
  providedIn: 'root'
})
export class HairSalonService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getHairSalons(): Observable<any> {
    return this.http.get(`${this.apiUrl}/hair-salon`);
  }

  getOneHairSalon(id:number): Observable<any> {
    return this.http.get(`${this.apiUrl}/hair-salon/`+id);
  }

  postData(data: HairSalonReq): Observable<any> {
    return this.http.post(`${this.apiUrl}/hair-salon`, data);
  }

  putData(data: HairSalonReq,id:number): Observable<any> {
    return this.http.put(`${this.apiUrl}/hair-salon/`+id, data);
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/hair-salon/${id}`);
  }
}
