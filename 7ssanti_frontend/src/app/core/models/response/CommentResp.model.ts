import { ClientReq } from "../request/ClientReq.model"

export interface CommentResp{
    id:number
    content:String
    article_id:number
    client:ClientReq
}