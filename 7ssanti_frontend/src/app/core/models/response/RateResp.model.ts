import { ClientReq } from "../request/ClientReq.model"

export interface RateResp {
    id:number
    note:String|''
    rate:number
    client:ClientReq
}