package com.orcamo.hssanti.domains.users.client;

import com.orcamo.hssanti.domains.users.client.dtos.ClientReq;
import com.orcamo.hssanti.domains.users.client.dtos.ClientResp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class ClientService implements ClientServiceInterface{
    private final ClientRepository clientRepository;
    @Override
    public ClientResp create(ClientReq clientReq) {
        return null;
    }

    @Override
    public ClientResp update(ClientReq clientReq, Integer integer) {
        return null;
    }

    @Override
    public Integer delete(Integer integer) {
        return null;
    }

    @Override
    public List<ClientResp> getAll() {
        return null;
    }

    @Override
    public ClientResp getOne(Integer integer) {
        return null;
    }
}
