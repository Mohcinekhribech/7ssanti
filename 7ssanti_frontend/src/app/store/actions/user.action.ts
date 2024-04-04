import { createAction, props } from '@ngrx/store';
import { UserReq } from 'src/app/core/models/request/UserReq.model';
import { UserResp } from 'src/app/core/models/response/UserResp.model';

export const successLogin = createAction('[Auth] SucessLogin', props<{user : UserResp , token:string }>());
export const failedLogin = createAction('[Auth] FailedLogin', props<{ error : String }>());

export const logout = createAction('[Auth] Logout');