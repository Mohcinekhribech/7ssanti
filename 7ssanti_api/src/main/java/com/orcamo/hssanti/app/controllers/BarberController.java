package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.services.interfaces.BarberServiceInterface;
import com.orcamo.hssanti.app.dtos.request.BarberReq;
import com.orcamo.hssanti.app.dtos.response.BarberResp;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barber")
public class BarberController extends CrudController<BarberReq, BarberResp, Integer , BarberServiceInterface> {
    public BarberController(BarberServiceInterface barberServiceInterface, ResponseMessage responseMessage) {
        super(barberServiceInterface, responseMessage);
    }
}
