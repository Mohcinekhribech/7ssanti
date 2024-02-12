import { ClientReq } from "../request/ClientReq.model"
import { CommentReq } from "../request/CommentReq.model"
import { MediaReq } from "../request/MediaReq.model"
import { BarberResp } from "./BarberResp.model"
import { CommentResp } from "./CommentResp.model"

export interface ArticleResp {
    id:number
    description:String
    barber:BarberResp|null
    medias:MediaReq[]
    likes:ClientReq[]
    comments:CommentResp[]
}