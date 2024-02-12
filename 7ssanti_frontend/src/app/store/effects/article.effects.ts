// my.effects.ts
import { Injectable, effect } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { Observable, of } from 'rxjs';
import { catchError, map, mergeMap } from 'rxjs/operators';
import { ArticleService } from 'src/app/core/services/article.service';
import * as MyActions from 'src/app/store/actions/article.action'; 

@Injectable()
export class ArticleEffects {
//   addData$ = createEffect(() =>
//     this.actions$.pipe(
//       ofType(MyActions.addQuiz),
//       mergeMap((quiz) =>
//         this.myService.postData(quiz.quiz).pipe(
//           map(data => MyActions.successAdd({ quiz : data }))
//         )
//       )
//     )
//   );

  fetchData$ = createEffect(() =>
    this.actions$.pipe(
      ofType(MyActions.fetchArticle),
      mergeMap(() =>
        this.myService.getArticles().pipe(
          map(data => {
            console.log(data)
            return MyActions.successFetch({ articles: data })
        })
        )
      )
    )
  );
  deleteData$ = createEffect(() =>
    this.actions$.pipe(
      ofType(MyActions.deleteArticle),
      mergeMap((data) =>
        this.myService.deleteData(data.id).pipe(
          map(() => {
            console.log(data)
            return MyActions.deleteArticle({ id: data.id })
            return data
        })
        )
      )
    )
  );

  constructor(
    private actions$: Actions,
    private myService: ArticleService
  ) {}
}
