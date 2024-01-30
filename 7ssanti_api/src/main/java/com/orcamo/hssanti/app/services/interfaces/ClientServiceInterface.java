package com.orcamo.hssanti.app.services.interfaces;

import com.orcamo.hssanti.app.dtos.request.ClientReq;
import com.orcamo.hssanti.app.dtos.response.ClientResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface ClientServiceInterface extends CrudInterface<ClientReq, ClientResp,Integer> {
}
