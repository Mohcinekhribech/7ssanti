import { createReducer, on } from "@ngrx/store";
import { UserState } from "../states/user.state";
import { failedLogin, successLogin } from "../actions/user.action";

const initialState:UserState = {
    user: null,
    token: '',
    error: ''
}

export const authReducer = createReducer(
    initialState,
    on(successLogin, (state, {user , token }) => ({ ...state,user,token })),
    on(failedLogin, (state, {error}) => ({ ...state, user : null,error:error }))
    // on(logout, (state) => ({ ...state, token: null }))
    
  );