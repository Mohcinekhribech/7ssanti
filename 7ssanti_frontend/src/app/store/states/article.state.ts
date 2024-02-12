import { ArticleResp } from "src/app/core/models/response/ArticleResp.model";

export interface ArticleState {
    articles: ArticleResp[];
    error: any;
  }