import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './components/shareable/nav-bar/nav-bar.component';
import { PrimaryButtonComponent } from './components/shareable/buttons/primary-button/primary-button.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { AllArticlesComponent } from './components/Articles/all-articles/all-articles.component';
import { ArticleFormComponent } from './components/Articles/article-form/article-form.component';
import { ArticleContentComponent } from './components/Articles/article-content/article-content.component';
import { SuggestedBarbersComponent } from './components/barbers/suggested-barbers/suggested-barbers.component';
import { SuggestedHairSalonComponent } from './components/hair-salon/suggested-hair-salon/suggested-hair-salon.component';
import { BarberProfileComponent } from './components/barbers/barber-profile/barber-profile.component';
import { LoginComponent } from './components/auth/login/login.component';
import { ModalComponent } from './components/shareable/modal/modal.component';
import { ArticleInfoComponent } from './components/Articles/article-info/article-info.component';
import { StoreModule } from '@ngrx/store';
import { articleReducer } from './store/reducers/article.reducer';
import { ArticleEffects } from './store/effects/article.effects';
import { EffectsModule } from '@ngrx/effects';
import { FormsModule } from '@angular/forms';
import { ArticleInfoInBarberProfileComponent } from './components/Articles/article-info-in-barber-profile/article-info-in-barber-profile.component';
import { ReservationComponent } from './components/reservations/reservation/reservation.component';
import { ChooseDateComponent } from './components/reservations/choose-date/choose-date.component';
import { ChooseTimeComponent } from './components/reservations/choose-time/choose-time.component';
import { ChooseServicesComponent } from './components/reservations/choose-services/choose-services.component';
import { PaimentComponent } from './components/reservations/paiment/paiment.component';
import { BarberServicesComponent } from './components/barbers/barber-services/barber-services.component';
import { AllBarbersComponent } from './components/barbers/all-barbers/all-barbers.component';
import { AllHairSalonComponent } from './components/hair-salon/all-hair-salon/all-hair-salon.component';
import { AllMyReservationsComponent } from './components/reservations/all-my-reservations/all-my-reservations.component';
import { reservationReducer } from './store/reducers/reservation.reducer';
import { RateFormComponent } from './components/rates/rate-form/rate-form.component';
import { AllRateComponent } from './components/rates/all-rate/all-rate.component';
import { ClaimFormComponent } from './components/claim/claim-form/claim-form.component';
import { CompetenceFormComponent } from './components/competence/competence-form/competence-form.component';
import { ShowCompetenceComponent } from './components/competence/show-competence/show-competence.component';
import { CompetenceComponent } from './components/competence/competence/competence.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    PrimaryButtonComponent,
    HomePageComponent,
    AllArticlesComponent,
    ArticleFormComponent,
    ArticleContentComponent,
    SuggestedBarbersComponent,
    SuggestedHairSalonComponent,
    BarberProfileComponent,
    LoginComponent,
    ModalComponent,
    ArticleInfoComponent,
    ArticleInfoInBarberProfileComponent,
    ReservationComponent,
    ChooseDateComponent,
    ChooseTimeComponent,
    ChooseServicesComponent,
    PaimentComponent,
    BarberServicesComponent,
    AllBarbersComponent,
    AllHairSalonComponent,
    AllMyReservationsComponent,
    RateFormComponent,
    AllRateComponent,
    ClaimFormComponent,
    CompetenceFormComponent,
    ShowCompetenceComponent,
    CompetenceComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    StoreModule.forRoot({ myFeature: articleReducer , reservationFeature: reservationReducer}),
    EffectsModule.forRoot(ArticleEffects),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
