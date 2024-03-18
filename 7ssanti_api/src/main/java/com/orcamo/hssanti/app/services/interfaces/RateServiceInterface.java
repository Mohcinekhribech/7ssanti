package com.orcamo.hssanti.app.services.interfaces;

import com.orcamo.hssanti.app.dtos.request.RateReq;
import com.orcamo.hssanti.app.dtos.response.RateResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface RateServiceInterface extends CrudInterface<RateReq, RateResp,Integer> {
}
