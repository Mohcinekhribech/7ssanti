package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.ClientReq;
import com.orcamo.hssanti.app.dtos.response.ClientResp;
import com.orcamo.hssanti.app.entities.Client;
import com.orcamo.hssanti.app.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        modelMapper = new ModelMapper();
        clientService = new ClientService(clientRepository, modelMapper);
    }

    @Test
    void testCreate() {
        // Arrange
        ClientReq clientReq = new ClientReq();
        Client client = modelMapper.map(clientReq, Client.class);
        ClientResp expectedResp = modelMapper.map(client, ClientResp.class);

        when(clientRepository.save(any(Client.class))).thenReturn(client);

        // Act
        ClientResp result = clientService.create(clientReq);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testUpdate() {
        // Arrange
        Client existingClient = new Client();
        existingClient.setId(1);
        ClientReq clientReq = new ClientReq();
        Client updatedClient = modelMapper.map(clientReq, Client.class);
        updatedClient.setId(1);
        ClientResp expectedResp = modelMapper.map(updatedClient, ClientResp.class);

        when(clientRepository.findById(1)).thenReturn(Optional.of(existingClient));
        when(clientRepository.save(any(Client.class))).thenReturn(updatedClient);

        // Act
        ClientResp result = clientService.update(clientReq, 1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testDelete() {
        // Arrange
        Client client = new Client();
        client.setId(1);

        when(clientRepository.findById(1)).thenReturn(Optional.of(client));

        // Act
        Integer result = clientService.delete(1);

        // Assert
        assertEquals(1, result);
        verify(clientRepository, times(1)).delete(client);
    }

    @Test
    void testGetAll() {
        // Arrange
        Client client1 = new Client();
        Client client2 = new Client();
        List<Client> clients = Arrays.asList(client1, client2);
        List<ClientResp> expectedResp = clients.stream()
                .map(c -> modelMapper.map(c, ClientResp.class))
                .toList();

        when(clientRepository.findAll()).thenReturn(clients);

        // Act
        List<ClientResp> result = clientService.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testGetOne() {
        // Arrange
        Client client = new Client();
        client.setId(1);
        ClientResp expectedResp = modelMapper.map(client, ClientResp.class);

        when(clientRepository.findById(1)).thenReturn(Optional.of(client));

        // Act
        ClientResp result = clientService.getOne(1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }
}
