import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { Store } from '@ngrx/store';
import { AuthService } from '../core/services/auth.service';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private store:Store, private router: Router,private authService:AuthService,private jwtHelper: JwtHelperService) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
    ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      
        const allowedRoles = route.data['allowedRoles'];
        const token = this.authService.getAuthToken();
        console.log(this.authService.isAuthenticated());
        
    if (this.authService.isAuthenticated() && allowedRoles.includes(this.authService.getAuthUser()?.role) && !this.isTokenExpired(token)) {      
      return of(true);
    } else {
      return this.router.createUrlTree(['/login']);
    }
  }

  
  isTokenExpired(token: string): boolean {
    if (!token) {
      return true;
    }
    try {
      return this.jwtHelper.isTokenExpired(token);
    } catch (error) {
      console.error('Error decoding or parsing the token:', error);
      return true;
    }
  }
}
