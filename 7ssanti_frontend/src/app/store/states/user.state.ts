import { UserResp } from "src/app/core/models/response/UserResp.model";

export interface UserState {
    user: UserResp| null;
    token: string;
    error: any;
  }