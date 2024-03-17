import { Time } from '@angular/common';
import { createAction, props } from '@ngrx/store';
import { ReservationReq } from 'src/app/core/models/request/ReservatonReq.model';

export const addReservation = createAction('[Reservation Component] add reservation',
props<{ reservation: ReservationReq }>());
export const addDateInReservation = createAction('[Reservation Component] add date reservation',
props<{ date: Date }>());
export const addStartTimeInReservation = createAction('[Reservation Component] add start time reservation',
props<{ startTime: String }>());
export const addServicesReservation = createAction('[Reservation Component] add services reservation',
props<{ services: number[] }>());
export const removeService = createAction(
    '[Service] Remove Service',
    props<{ id: number }>()
);