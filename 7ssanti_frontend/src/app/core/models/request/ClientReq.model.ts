import { UserReq } from "./UserReq.model";

export interface ClientReq extends UserReq {
    registrationDate:String|null
}