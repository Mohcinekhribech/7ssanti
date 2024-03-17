import { createSelector, createFeatureSelector } from '@ngrx/store';
import { ReservationState } from '../states/reservation.state';

const selectMyFeature = createFeatureSelector<ReservationState>('reservationFeature');

export const selectReservation = createSelector(
  selectMyFeature,
  (state: ReservationState) => state.reservation
);

export const selectservicesReserved = createSelector(
  selectMyFeature,
  (state: ReservationState) => state.services
);