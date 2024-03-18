package com.orcamo.hssanti.app.services.interfaces;

import com.orcamo.hssanti.app.dtos.request.ClaimReq;
import com.orcamo.hssanti.app.dtos.response.ClaimResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface ClaimServiceInterface extends CrudInterface<ClaimReq, ClaimResp,Integer> {
}
