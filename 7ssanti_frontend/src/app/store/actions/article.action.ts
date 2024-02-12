import { createAction, props } from '@ngrx/store';
import { ArticleReq } from 'src/app/core/models/request/ArticleReq.model';
import { ClientReq } from 'src/app/core/models/request/ClientReq.model';
import { ArticleResp } from 'src/app/core/models/response/ArticleResp.model';

export const successAdd = createAction('[Article Component] successAdd',
props<{ article: ArticleResp }>());
export const fetchArticle= createAction('[Article Component] fetchQuiz');
export const successFetch = createAction('[Article Component] successFetch',
props<{ articles: ArticleResp[] }>());
export const updateArticle = createAction('[Article Component] likeArticle',
props<{ id: number , article : ArticleResp }>());
export const deleteArticle= createAction('[Article Component] delete',
props<{ id: number }>());
export const successDelete = createAction('[Article Component] delete',
props<{ id: number }>());
export const nextPage = createAction('[Article Component] next');
export const prevPage = createAction('[Article Component] Reset');