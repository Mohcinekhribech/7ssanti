package com.orcamo.hssanti.app.services.interfaces;

import com.orcamo.hssanti.app.dtos.request.ServiceReq;
import com.orcamo.hssanti.app.dtos.response.ServiceResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface ServiceServiceInterface extends CrudInterface<ServiceReq, ServiceResp,Integer> {
}
