package com.orcamo.hssanti.domains.users.client;

import com.orcamo.hssanti.domains.users.client.dtos.ClientReq;
import com.orcamo.hssanti.domains.users.client.dtos.ClientResp;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController extends CrudController<ClientReq, ClientResp,Integer,ClientServiceInterface> {
    public ClientController(ClientServiceInterface clientServiceInterface, ResponseMessage responseMessage) {
        super(clientServiceInterface, responseMessage);
    }
}
