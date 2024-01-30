package com.orcamo.hssanti.app.services.interfaces;

import com.orcamo.hssanti.app.dtos.request.HairSalonReq;
import com.orcamo.hssanti.app.dtos.response.HairSalonResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface HairSalonServiceInterface extends CrudInterface<HairSalonReq, HairSalonResp ,Integer> {
}
