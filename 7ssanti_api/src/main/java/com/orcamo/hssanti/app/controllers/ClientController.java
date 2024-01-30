package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.services.interfaces.ClientServiceInterface;
import com.orcamo.hssanti.app.dtos.request.ClientReq;
import com.orcamo.hssanti.app.dtos.response.ClientResp;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController extends CrudController<ClientReq, ClientResp,Integer, ClientServiceInterface> {
    public ClientController(ClientServiceInterface clientServiceInterface, ResponseMessage responseMessage) {
        super(clientServiceInterface, responseMessage);
    }
}
