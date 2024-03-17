import { Time } from "@angular/common";

export interface ReservationReq{
    id:number
    date:Date | ''
    startTime:String | ''
    endTime:String | ''
    etat:String
    clientId:number
}