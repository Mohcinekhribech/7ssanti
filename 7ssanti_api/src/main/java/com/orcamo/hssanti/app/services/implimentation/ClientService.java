package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.ClientReq;
import com.orcamo.hssanti.app.dtos.response.ClientResp;
import com.orcamo.hssanti.app.entities.Client;
import com.orcamo.hssanti.app.repositories.ClientRepository;
import com.orcamo.hssanti.app.services.interfaces.ClientServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClientService implements ClientServiceInterface {
    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;
    @Override
    public ClientResp create(ClientReq clientReq) {
        Client client =  clientRepository.save(modelMapper.map(clientReq,Client.class));
        return modelMapper.map(client, ClientResp.class);
    }

    @Override
    public ClientResp update(ClientReq clientReq, Integer id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        return clientOptional.map(client -> {
            clientReq.setId(client.getId());
            client = clientRepository.save(modelMapper.map(clientReq,Client.class));
            return modelMapper.map(client,ClientResp.class);
        }).orElse(null);
    }

    @Override
    public Integer delete(Integer id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        return clientOptional.map(client -> {
                    clientRepository.delete(client);
                    return 1;
                })
                .orElse(0);
    }

    @Override
    public List<ClientResp> getAll() {
        return clientRepository.findAll().stream().map(client -> modelMapper.map(client,ClientResp.class)).collect(Collectors.toList());
    }

    @Override
    public ClientResp getOne(Integer id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        return modelMapper.map(clientOptional.orElse(null),ClientResp.class);
    }
}
