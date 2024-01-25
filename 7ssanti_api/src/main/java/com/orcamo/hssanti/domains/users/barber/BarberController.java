package com.orcamo.hssanti.domains.users.barber;

import com.orcamo.hssanti.domains.users.barber.dtos.BarberReq;
import com.orcamo.hssanti.domains.users.barber.dtos.BarberResp;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;

public class BarberController extends CrudController<BarberReq, BarberResp, Integer ,BarberServiceInterface> {
    public BarberController(BarberServiceInterface barberServiceInterface, ResponseMessage responseMessage) {
        super(barberServiceInterface, responseMessage);
    }
}
