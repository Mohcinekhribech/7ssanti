package com.orcamo.hssanti.domains.hairSalon;

import com.orcamo.hssanti.domains.hairSalon.dtos.HairSalonReq;
import com.orcamo.hssanti.domains.hairSalon.dtos.HairSalonResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface HairSalonServiceInterface extends CrudInterface<HairSalonReq, HairSalonResp ,Integer> {
}
