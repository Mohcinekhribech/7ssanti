import { ArticleResp } from "./ArticleResp.model";
import { UserResp } from "./UserResp.model";

export interface BarberResp extends UserResp {
    yearsOfExperience:String
    articles:ArticleResp[]
}