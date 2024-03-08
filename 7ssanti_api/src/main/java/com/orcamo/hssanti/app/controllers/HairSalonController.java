package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.services.interfaces.HairSalonServiceInterface;
import com.orcamo.hssanti.app.dtos.request.HairSalonReq;
import com.orcamo.hssanti.app.dtos.response.HairSalonResp;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hair-salon")
public class HairSalonController extends CrudController<HairSalonReq, HairSalonResp,Integer, HairSalonServiceInterface> {
    public HairSalonController(HairSalonServiceInterface hairSalonServiceInterface, ResponseMessage responseMessage) {
        super(hairSalonServiceInterface, responseMessage);
    }
}