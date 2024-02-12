import { UserReq } from "./UserReq.model"

export interface BarberReq extends UserReq {
    yearsOfExperience:String
}