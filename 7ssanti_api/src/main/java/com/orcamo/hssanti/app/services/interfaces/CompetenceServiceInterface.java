package com.orcamo.hssanti.app.services.interfaces;

import com.orcamo.hssanti.app.dtos.request.CompetenceReq;
import com.orcamo.hssanti.app.dtos.response.CompetenceResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface CompetenceServiceInterface extends CrudInterface<CompetenceReq, CompetenceResp,Integer> {
    public Boolean competenceVerified(Integer id);
}
