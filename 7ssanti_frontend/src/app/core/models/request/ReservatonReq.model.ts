import { Time } from "@angular/common";

export interface ReservationReq{
    id:number
    date:Date | ''
    startTime:Time | ''
    endTime:Time | ''
    etat:String
    clientId:number
}