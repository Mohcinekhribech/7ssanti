import { ReservationReq } from "src/app/core/models/request/ReservatonReq.model";

export interface ReservationState {
    reservation: ReservationReq
    error:String |''
    services:number[]
  }