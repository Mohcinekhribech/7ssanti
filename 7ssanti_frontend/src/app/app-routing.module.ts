import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllArticlesComponent } from './components/Articles/all-articles/all-articles.component';
import { BarberProfileComponent } from './components/barbers/barber-profile/barber-profile.component';
import { ReservationComponent } from './components/reservations/reservation/reservation.component';
import { ArticleInfoComponent } from './components/Articles/article-info/article-info.component';
import { BarberServicesComponent } from './components/barbers/barber-services/barber-services.component';
import { LoginComponent } from './components/auth/login/login.component';

const routes: Routes = [
  {path:'login',component:LoginComponent},
  {path:'feeds',component:AllArticlesComponent},
  {path:'feeds/:id',component:ArticleInfoComponent},
  {path:'barber/:id',component:BarberProfileComponent},
  {path:'barber/:id/reservation',component:ReservationComponent},
  {path:'barber/:id/services',component:BarberServicesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
