package com.orcamo.hssanti.app.services.interfaces;

import com.orcamo.hssanti.app.dtos.request.BarberReq;
import com.orcamo.hssanti.app.dtos.response.BarberResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface BarberServiceInterface extends CrudInterface<BarberReq, BarberResp,Integer> {
}
