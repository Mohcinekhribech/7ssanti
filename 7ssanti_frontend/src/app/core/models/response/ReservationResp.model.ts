import { Time } from "@angular/common";
import {ClientReq} from "../request/ClientReq.model"
import { ServiceReq } from "../request/ServiceReq.model";
import { ServiceForReservationReq } from "../request/ServiceForReservationReq.model";

export interface ReservationResp{
    id:number
    date:Date | ''
    startTime:Time | ''
    endTime:Time | ''
    etat:String
    price:number
    client:ClientReq
    services:ServiceForReservationReq[]
}