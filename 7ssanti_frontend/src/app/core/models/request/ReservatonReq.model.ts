import { Time } from "@angular/common";

export interface ReservationReq{
    id:number
    date:Date | ''
    startTime:String | ''
    endTime:String | ''
    etat:'PENDING'|'PASSED'|'NOT_PASSED'
    clientId:number
    price:number
}