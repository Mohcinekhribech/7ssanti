import { createSelector, createFeatureSelector } from '@ngrx/store';
import { UserState } from '../states/user.state';

const selectMyFeature = createFeatureSelector<UserState>('userFeature');

export const selectToken = createSelector(
  selectMyFeature,
  (state: UserState) => state.token
);

export const selectUser = createSelector(
    selectMyFeature,
    (state: UserState) => state.user
  );
  
export const selecUsertError = createSelector(
  selectMyFeature,
  (state: UserState) => state.error
);

export const selectUserState = createSelector(
    selectMyFeature,
    (state: UserState) => state
  );
