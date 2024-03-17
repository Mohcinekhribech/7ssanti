import { createReducer, on } from "@ngrx/store";
import { ReservationState } from "../states/reservation.state";
import { addDateInReservation, addReservation, addServicesReservation, addStartTimeInReservation, removeService } from "../actions/reservation.action";


export const reservationState:ReservationState={
    reservation: {
        id: 0,
        date: "",
        startTime: "",
        endTime: "",
        etat: '',
        clientId: 0
    },
    error: "",
    services: []
} ;
export const reservationReducer = createReducer(
    reservationState,
    on(addReservation, (state,{reservation}) => ({...state,reservation:reservation,error : ""})),
    on(addDateInReservation, (state,{date}) => ({...state,reservation:{ ...state.reservation,date:date},error : ""})),
    on(addStartTimeInReservation, (state,{startTime}) =>({...state,reservation:{ ...state.reservation,startTime:startTime},error : ""})),
    on(addServicesReservation, (state,{services}) => ({...state,services:services,error : ""})),
    on(removeService, (state, { id }) => ({
        ...state,
        services: state.services.filter(service => service !== id)
      }))
  );
