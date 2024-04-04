import { Injectable } from '@angular/core';
import { UserResp } from '../models/response/UserResp.model';
import { Observable, of } from 'rxjs';
import { UserReq } from '../models/request/UserReq.model';
import { HttpClient } from '@angular/common/http';
import { JwtHelperService } from '@auth0/angular-jwt';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/auth';
  private jwtHelper: JwtHelperService = new JwtHelperService();
  
  constructor(private http: HttpClient,private cookieService: CookieService) {}

  clientRegister(data:any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register-client`,data);
  }

  barberRegister(data:any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register-barber`,data);
  }

  authentication(data:any): Observable<any> {
    return this.http.post(`${this.apiUrl}/authenticate`,data);
  }

  getUserInfo(token: string): any {
    const decodedToken = this.jwtHelper.decodeToken(token);
    return decodedToken;
  }

  setAuthInfo(token: string,user:UserResp): void {
    this.cookieService.set('token', token);
    this.cookieService.set('user', JSON.stringify(user));
  }

  getAuthToken() : string
  {
    // console.log(this.cookieService.get('token'))
    return this.cookieService.get('token');
  }
  getAuthUser(): UserResp | null {
    const userString = this.cookieService.get('user');
  
    if (!userString) {
      return null;  // 'user' cookie does not exist
    }
  
    try {
      return JSON.parse(userString) as UserResp;
    } catch (error) {
      console.error('Error parsing user cookie:', error);
      return null;
    }
  }

  // Clear the authentication token from the cookie
  clearAuthToken(): void {
    this.cookieService.delete('token');
    this.cookieService.delete('user');
  }

  // Check if the user is authenticated based on the presence of a valid token in the cookie
  isAuthenticated(): boolean {
    return this.cookieService.check('token');
  }

  logout(): Observable<any> {
    return this.http.post(this.apiUrl+'/logout', {});
  }
}
