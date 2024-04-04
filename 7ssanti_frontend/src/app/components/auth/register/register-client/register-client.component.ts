import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable, catchError, map, of } from 'rxjs';
import { ClientReq } from 'src/app/core/models/request/ClientReq.model';
import { AuthService } from 'src/app/core/services/auth.service';
import { successLogin } from 'src/app/store/actions/user.action';
import { selectUserState } from 'src/app/store/selectors/user.selectors';

@Component({
  selector: 'app-register-client',
  templateUrl: './register-client.component.html',
  styleUrls: ['./register-client.component.css']
})
export class RegisterClientComponent {
  constructor(private store: Store, private router: Router,private authService:AuthService , private http: HttpClient,) {}
  info: ClientReq = {
    id: 0,
    fullName: '',
    dateOfBirth: '',
    email: '',
    password: '',
    role: 'Client',
    registrationDate: null,
    profilePic: ''
  };
  pic:any;
  error: String = '';
  register() {
    if(this.pic)
    {
      this.uploadImage(this.pic);
    }
    setTimeout(() => {
      this.authService.clientRegister(this.info).subscribe(res => {
          this.store.dispatch(successLogin({
            user: res.user,
            token: res.access_token,
          }));
        })
    },1000)
    setTimeout(() => {
      this.store.select(selectUserState).subscribe((res) => {
        if (res.token && res.user) {
          this.authService.setAuthInfo(res.token,res.user);
          this.router.navigate(['/feeds']);
        } else {
          this.error = 'email or password incorrect';
        }
      });
    }, 1000);
  }

  addImage(fileInput: any) {
 
        this.pic = fileInput.files[0]; // Store files in the files array
  }

  uploadImage(file: any) {
    const formData = new FormData();
    formData.append('file', file);  
  
    this.http.post<any>('http://127.0.0.1:5000/upload-image', formData).subscribe(
    (response: { url: any }) => {
      console.log(response);
      this.info.profilePic = response.url;
    },
    (error: any) => {
      console.error('Error:', error);
      // Handle error
    }
  );
  }
  
  
}
