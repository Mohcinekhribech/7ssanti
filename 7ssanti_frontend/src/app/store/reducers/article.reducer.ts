import { createReducer, on } from '@ngrx/store';
import { ArticleResp } from 'src/app/core/models/response/ArticleResp.model';
import { fetchArticle, successAdd, successDelete, successFetch, updateArticle } from '../actions/article.action';
import { ArticleState } from '../states/article.state';



export const articleState:ArticleState={
  articles: [],
  error: ""
} ;

export const articleReducer = createReducer(
  articleState,
  on(successAdd, (state,{article}) => ({...state,articles:[...state.articles,article],error : ""})),
  on(successFetch, (state,{articles}) => ({...state,articles:[...articles],error:""})),
  on(successDelete, (state, { id }) => ({
    ...state,
    quizs: state.articles.filter(quiz => quiz.id !== id),
    error: null
  })),
  on(updateArticle, (state, { id, article }) => {
    const index = state.articles.findIndex(item => item.id === id);
    if (index === -1) {
        // Element not found, return current state
        return state;
    }
    // Update the specific element
    const updatedArticles = [...state.articles]; // Create a shallow copy of the articles array
    updatedArticles[index] = { ...updatedArticles[index], ...article }; // Update the specific article
    return { ...state, articles: updatedArticles }; // Return a new state object with updated articles
}),
  on(fetchArticle, (state) => state)
);