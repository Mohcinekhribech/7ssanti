package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.dtos.request.ServiceReq;
import com.orcamo.hssanti.app.dtos.response.ServiceResp;
import com.orcamo.hssanti.app.services.interfaces.ServiceServiceInterface;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceController extends CrudController<ServiceReq , ServiceResp , Integer , ServiceServiceInterface> {
    public ServiceController(ServiceServiceInterface serviceServiceInterface, ResponseMessage responseMessage) {
        super(serviceServiceInterface, responseMessage);
    }
}