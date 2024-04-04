import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { UserResp } from 'src/app/core/models/response/UserResp.model';
import { AuthService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-dashrboard',
  templateUrl: './dashrboard.component.html',
  styleUrls: ['./dashrboard.component.css']
})
export class DashrboardComponent {
  constructor(private cookiesService: CookieService, private authService: AuthService , private router: Router) {}
  user: UserResp | null = null;
  ngOnInit() {
    this.user = this.authService.getAuthUser();
  }

  logout(): void {
    this.authService.logout().subscribe(
      () => {
        this.cookiesService.deleteAll();
        this.router.navigate(['/login']);
      },
      (error) => {
        console.error('Error logging out:', error);
      }
    );
  }

  
  sideBar() {
    var side = document.querySelectorAll('.side');
    var sideBar = document.querySelectorAll('.sideBar');
    var image = document.querySelectorAll('.image');
    image[0].classList.toggle('w-8');
    image[0].classList.toggle('h-8');
    if (sideBar[0].classList.contains('w-[60px]')) {
      sideBar[0].classList.replace('max-sm:ml-[-58px]', 'max-sm:ml-0');
      sideBar[0].classList.replace('w-[60px]', 'w-60');
    } else {
      sideBar[0].classList.replace('w-60', 'w-[60px]');
      sideBar[0].classList.replace('max-sm:ml-0', 'max-sm:ml-[-58px]');
    }
    for (var i in side) {
      if (side[i].classList) {
        side[i].classList.toggle('hidden');
      }
    }
  }
}
