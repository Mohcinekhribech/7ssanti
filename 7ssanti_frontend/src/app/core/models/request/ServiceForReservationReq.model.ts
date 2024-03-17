import { BarberReq } from "./BarberReq.model"

export interface ServiceForReservationReq {
    id:number 
    name:String |'' 
    timeIstimation:number 
    price:number 
    description:String | '' 
    barber:BarberReq 
}