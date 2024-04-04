import { CompetenceReq } from "../request/CompetenceReq.model";
import { RateReq } from "../request/RateReq.model";
import { ServiceReq } from "../request/ServiceReq.model";
import { ArticleResp } from "./ArticleResp.model";
import { UserResp } from "./UserResp.model";

export interface BarberResp extends UserResp {
    yearsOfExperience:String
    articles:ArticleResp[]
    services:ServiceReq[]
    rates:RateReq[]
    competences: CompetenceReq[]
}