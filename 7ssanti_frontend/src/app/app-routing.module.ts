import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllArticlesComponent } from './components/Articles/all-articles/all-articles.component';
import { BarberProfileComponent } from './components/barbers/barber-profile/barber-profile.component';
import { ReservationComponent } from './components/reservations/reservation/reservation.component';
import { ArticleInfoComponent } from './components/Articles/article-info/article-info.component';
import { BarberServicesComponent } from './components/barbers/barber-services/barber-services.component';
import { LoginComponent } from './components/auth/login/login.component';
import { AllBarbersComponent } from './components/barbers/all-barbers/all-barbers.component';
import { AllHairSalonComponent } from './components/hair-salon/all-hair-salon/all-hair-salon.component';
import { AllMyReservationsComponent } from './components/reservations/all-my-reservations/all-my-reservations.component';
import { RegisterClientComponent } from './components/auth/register/register-client/register-client.component';
import { RegisterBarberComponent } from './components/auth/register/register-barber/register-barber.component';
import { AuthGuard } from './guards/Auth.guard';
import { ClientComponent } from './components/admin/client/client.component';
import { BarbersComponent } from './components/admin/barbers/barbers.component';
import { ClaimsComponent } from './components/admin/claims/claims.component';

const routes: Routes = [
  {path:'login',component:LoginComponent},
  {path:'admin/clients',component:ClientComponent,canActivate: [AuthGuard] , data: { allowedRoles: ['Admin'] }},
  {path:'admin/barbers',component:BarbersComponent,canActivate: [AuthGuard] , data: { allowedRoles: ['Admin'] }},
  {path:'admin/claims',component:ClaimsComponent,canActivate: [AuthGuard] , data: { allowedRoles: ['Admin'] }},
  {path:'register-client',component:RegisterClientComponent},
  {path:'register-barber',component:RegisterBarberComponent},
  {path:'feeds',component:AllArticlesComponent,canActivate: [AuthGuard] , data: { allowedRoles: ['Barber','Client'] }},
  {path:'feeds/:id',component:ArticleInfoComponent,canActivate: [AuthGuard] , data: { allowedRoles: ['Barber','Client'] }},
  {path:'barber/:id',component:BarberProfileComponent,canActivate: [AuthGuard] , data: { allowedRoles: ['Barber','Client'] }},
  {path:'barber/:id/reservation',component:ReservationComponent,canActivate: [AuthGuard] , data: { allowedRoles: ['Barber','Client'] }},
  {path:'barber/:id/services',component:BarberServicesComponent,canActivate: [AuthGuard] , data: { allowedRoles: ['Barber','Client'] }},
  {path:'barber',component:AllBarbersComponent,canActivate: [AuthGuard] , data: { allowedRoles: ['Barber','Client'] }},
  {path:'hair-salon',component:AllHairSalonComponent,canActivate: [AuthGuard] , data: { allowedRoles: ['Barber','Client'] }},
  {path:'reservations',component:AllMyReservationsComponent,canActivate: [AuthGuard] , data: { allowedRoles: ['Barber','Client'] }},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
