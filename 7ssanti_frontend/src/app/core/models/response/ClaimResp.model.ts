import { UserReq } from "../request/UserReq.model"

export interface ClaimResp {
    id:number
    content:string | ''
    user:UserReq
}