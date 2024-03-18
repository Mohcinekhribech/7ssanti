package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.dtos.request.ClaimReq;
import com.orcamo.hssanti.app.dtos.response.ClaimResp;
import com.orcamo.hssanti.app.services.interfaces.ClaimServiceInterface;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/claim")
public class ClaimController extends CrudController<ClaimReq, ClaimResp,Integer, ClaimServiceInterface> {
    public ClaimController(ClaimServiceInterface claimServiceInterface, ResponseMessage responseMessage) {
        super(claimServiceInterface, responseMessage);
    }
}
