package com.orcamo.hssanti.domains.users.client;

import com.orcamo.hssanti.domains.users.client.dtos.ClientReq;
import com.orcamo.hssanti.domains.users.client.dtos.ClientResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface ClientServiceInterface extends CrudInterface<ClientReq, ClientResp,Integer> {
}
