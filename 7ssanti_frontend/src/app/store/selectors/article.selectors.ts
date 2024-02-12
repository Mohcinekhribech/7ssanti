import { createSelector, createFeatureSelector } from '@ngrx/store';
import { ArticleState } from '../states/article.state';
import { ArticleResp } from 'src/app/core/models/response/ArticleResp.model';

const selectMyFeature = createFeatureSelector<ArticleState>('myFeature');

export const selectArticles = createSelector(
  selectMyFeature,
  (state: ArticleState) => state.articles
);

export const selectArticleById = (articleId: number) => createSelector(
  selectArticles,
  (articles: ArticleResp[]) => {
    return articles.find(article => article.id === articleId);
  }
);


export const selectError = createSelector(
  selectMyFeature,
  (state: ArticleState) => state.error
);
