import { BarberReq } from "../request/BarberReq.model"

export interface ServiceResp {
    id:number 
    name:String |'' 
    timeIstimation:number 
    price:number 
    description:String | '' 
    barber:BarberReq | null 
}