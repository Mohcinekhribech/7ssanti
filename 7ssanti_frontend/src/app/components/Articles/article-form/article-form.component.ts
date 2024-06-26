import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, Input } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Observable, catchError, concatMap, forkJoin, map, of } from 'rxjs';
import { ArticleReq } from 'src/app/core/models/request/ArticleReq.model';
import { MediaReq } from 'src/app/core/models/request/MediaReq.model';
import { UserResp } from 'src/app/core/models/response/UserResp.model';
import { ArticleService } from 'src/app/core/services/article.service';
import { AuthService } from 'src/app/core/services/auth.service';
import { MediaService } from 'src/app/core/services/media.service';
import { fetchArticle } from 'src/app/store/actions/article.action';
import { selectUser } from 'src/app/store/selectors/user.selectors';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-article-form',
  templateUrl: './article-form.component.html',
  styleUrls: ['./article-form.component.css'],
})
export class ArticleFormComponent {
  @Input() user : UserResp |null ={
    id: 0,
    fullName: '',
    profilePic: '',
    dateOfBirth: '',
    email: '',
    role: ''
  }
  showForm = false;
  images: any[] = [];
  videos: any[] = [];
  numOfFiles: number = 0;
  picFiles: any[] = [];
  videoFiles: any[] = [];
  medias: MediaReq[] = [];
  media: MediaReq = {
    id: 0,
    mediaLink: '',
    type: '',
    article_id: 0,
  };

  article: ArticleReq = {
    id: null,
    description: '',
    barber_id: 0,
  };

  constructor(
    private http: HttpClient,
    private store: Store,
    private articleService: ArticleService,
    private mediaService: MediaService,
    private authService: AuthService
  ) {}

  ngOnInit()
  {
    var id = this.authService.getAuthUser()?.id;
    this.article.barber_id = id?id:0
    console.log(this.user);
    
  }

  closeModal(data: any) {
    this.showForm = false;
  }

  removePicture(i: number) {
    this.images.splice(i, 1);
    if (this.picFiles && this.picFiles.length > i) {
      this.picFiles.splice(i, 1);
    }
  }

  removeVideo(i: number) {
    console.log('alo');
    this.videos.splice(i, 1);
    if (this.videoFiles && this.videoFiles.length > i) {
      this.videoFiles.splice(i, 1);
      console.log('alo1');
    }
  }

  isImage(fileType: string): boolean {
    return fileType.startsWith('image/');
  }

  isVideo(fileType: string): boolean {
    return fileType.startsWith('video/');
  }

  uploadVideo(files: any[]) : Observable<any>
  {
      const observables: Observable<any>[] = [];
  
      for (let i = 0; i < files.length; i++) {
        const formData = new FormData();
        formData.append('file', files[i]);
        formData.append('upload_preset', 'ozbl32lz');
  
        const uploadObservable = this.http
          .post<any>('http://127.0.0.1:5000/upload-video', formData)
          .pipe(
            map((response: { url: any }) => {
              var media = {
                id: 0,
                mediaLink: response.url,
                type: 'VIDEO',
                article_id: 0,
              };
              this.medias = [...this.medias, media];
            }),
            catchError((error: any) => {
              console.error('Error:', error);
              // Return observable with error
              return of(null);
            })
          );
  
        observables.push(uploadObservable);
      }
  
      // Use forkJoin to combine all upload observables
      return forkJoin(observables).pipe(
        map(() => {
          console.log('All images uploaded successfully');
          return; // Return void
        }),
        catchError((error: any) => {
          console.error('Error occurred during image upload:', error);
          // Handle error here
          return of(null);
        })
      );
  
  }

  uploadImage(files: any[]): Observable<any> {
    const observables: Observable<any>[] = [];

    for (let i = 0; i < files.length; i++) {
      const formData = new FormData();
      formData.append('file', files[i]);
      formData.append('upload_preset', 'ozbl32lz');

      const uploadObservable = this.http
        .post<any>('http://127.0.0.1:5000/upload-image', formData)
        .pipe(
          map((response: { url: any }) => {
            console.log(response)
            var media = {
              id: 0,
              mediaLink: response.url,
              type: 'IMAGE',
              article_id: 0,
            };
            this.medias = [...this.medias, media];
          }),
          catchError((error: any) => {
            console.error('Error:', error);
            // Return observable with error
            return of(null);
          })
        );

      observables.push(uploadObservable);
    }

    // Use forkJoin to combine all upload observables
    return forkJoin(observables).pipe(
      map(() => {
        console.log('All images uploaded successfully');
        return; // Return void
      }),
      catchError((error: any) => {
        console.error('Error occurred during image upload:', error);
        // Handle error here
        return of(null);
      })
    );
  }

  // uploadImage(files: any[]) {
  //   for (let i = 0; i < files.length; i++) {
  //     const formData = new FormData();
  //     formData.append('file', files[i]);
  //     formData.append('upload_preset', 'ozbl32lz');
  //     this.http
  //       .post<any>('https://api.cloudinary.com/v1_1/dssb587ew/upload', formData)
  //       .subscribe(
  //         (response: { secure_url: any }) => {
  //           console.log(response);
  //           this.media.mediaLink = response.secure_url;
  //           this.medias = [...this.medias , this.media]
  //           console.log("medias",this.medias)
  //         },
  //         (error: any) => {
  //           console.error('Error:', error);
  //         }
  //       );
  //   }
  // }
  addVideo(fileInput: any) {
    const files = fileInput.files;
    if (files) {
      this.videos = []; // Clear previous images
      this.videoFiles = []; // Clear previous files
      this.numOfFiles = files.length;

      for (let i = 0; i < files.length; i++) {
        const reader = new FileReader();
        reader.onload = () => {
          this.videos.push(reader.result);
        };
        reader.readAsDataURL(files[i]);
        this.videoFiles.push(files[i]); // Store files in the files array
      }
    }
  }

  addImage(fileInput: any) {
    const files = fileInput.files;
    if (files) {
      this.images = []; // Clear previous images
      this.picFiles = []; // Clear previous files
      this.numOfFiles = files.length;

      for (let i = 0; i < files.length; i++) {
        const reader = new FileReader();
        reader.onload = () => {
          this.images.push(reader.result);
        };
        reader.readAsDataURL(files[i]);
        this.picFiles.push(files[i]); // Store files in the files array
      }
    }
  }
  postArticle() {
    this.articleService
      .postData(this.article)
      .pipe(
        concatMap((res) => {
          const uploadImageObservable = [];
          if (this.picFiles.length > 0) {
            uploadImageObservable.push(this.uploadImage(this.picFiles));
          }
          if (this.videoFiles.length > 0) {
            uploadImageObservable.push(this.uploadVideo(this.videoFiles));
          }
          // Check if there are any observables to join
          if (uploadImageObservable.length > 0) {
            return forkJoin(uploadImageObservable).pipe(
              concatMap(() => {
                this.medias.map((media) => (media.article_id = res.id));
                console.log(this.medias.length);
                return this.mediaService.postAllData(this.medias);
              })
            );
          } else {
            // If there are no observables to join, return an observable with an empty array
            return of([]);
          }
        }),
        catchError((error) => {
          console.error('Error occurred:', error);
          // Handle error here if needed
          return of(error); // Return observable to continue the stream
        })
      )
      .subscribe(() => {
        this.showForm = false
        Swal.fire({
        position: "center",
        icon: "success",
        title: "Your work has been saved",
        showConfirmButton: false,
        timer: 1500
      });
        
        this.store.dispatch(fetchArticle());
      });
  }

  // postArticle() {
  //   this.articleService.postData(this.article).subscribe((res) => {
  //     if (this.picFiles.length > 0) this.uploadImage(this.picFiles);
  //     if (this.videoFiles.length > 0) this.uploadImage(this.videoFiles);
  //     this.medias.map((media) => (media.article_id = res.id));
  //     console.log(this.medias.length)
  //     this.mediaService.postAllData(this.medias).subscribe(res => console.log(res))
  //     this.store.dispatch(fetchArticle())
  //   });
  // }
}
