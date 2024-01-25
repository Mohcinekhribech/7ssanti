package com.orcamo.hssanti.domains.users.barber;

import com.orcamo.hssanti.domains.users.barber.dtos.BarberReq;
import com.orcamo.hssanti.domains.users.barber.dtos.BarberResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface BarberServiceInterface extends CrudInterface<BarberReq, BarberResp,Integer> {
}
