import { BarberReq } from "../request/BarberReq.model"

export interface HairSalonResp {
    id:number
    name:String | '' 
    location:String | '' 
    barbers:BarberReq[]
}