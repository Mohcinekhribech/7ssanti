package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.dtos.request.RateReq;
import com.orcamo.hssanti.app.dtos.response.RateResp;
import com.orcamo.hssanti.app.services.implimentation.RateService;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate")
public class RateController extends CrudController<RateReq, RateResp , Integer ,RateService> {
    public RateController(RateService rateService, ResponseMessage responseMessage) {
        super(rateService, responseMessage);
    }
}
