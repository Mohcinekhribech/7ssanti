package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.BarberReq;
import com.orcamo.hssanti.app.dtos.response.BarberResp;
import com.orcamo.hssanti.app.entities.Barber;
import com.orcamo.hssanti.app.repositories.BarberRepository;
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

class BarberServiceTest {

    @Mock
    private BarberRepository barberRepository;

    @InjectMocks
    private BarberService barberService;

    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        modelMapper = new ModelMapper();
        barberService = new BarberService(barberRepository, modelMapper);
    }

    @Test
    void testCreate() {
        // Arrange
        BarberReq barberReq = new BarberReq();
        Barber barber = modelMapper.map(barberReq, Barber.class);
        BarberResp expectedResp = modelMapper.map(barber, BarberResp.class);

        when(barberRepository.save(any(Barber.class))).thenReturn(barber);

        // Act
        BarberResp result = barberService.create(barberReq);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testUpdate() {
        // Arrange
        Barber existingBarber = new Barber();
        existingBarber.setId(1);
        BarberReq barberReq = new BarberReq();
        Barber updatedBarber = modelMapper.map(barberReq, Barber.class);
        updatedBarber.setId(1);
        BarberResp expectedResp = modelMapper.map(updatedBarber, BarberResp.class);

        when(barberRepository.findById(1)).thenReturn(Optional.of(existingBarber));
        when(barberRepository.save(any(Barber.class))).thenReturn(updatedBarber);

        // Act
        BarberResp result = barberService.update(barberReq, 1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testDelete() {
        // Arrange
        Barber barber = new Barber();
        barber.setId(1);

        when(barberRepository.findById(1)).thenReturn(Optional.of(barber));

        // Act
        Integer result = barberService.delete(1);

        // Assert
        assertEquals(1, result);
        verify(barberRepository, times(1)).delete(barber);
    }

    @Test
    void testGetAll() {
        // Arrange
        Barber barber1 = new Barber();
        Barber barber2 = new Barber();
        List<Barber> barbers = Arrays.asList(barber1, barber2);
        List<BarberResp> expectedResp = barbers.stream()
                .map(b -> modelMapper.map(b, BarberResp.class))
                .toList();

        when(barberRepository.findAll()).thenReturn(barbers);

        // Act
        List<BarberResp> result = barberService.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testGetOne() {
        // Arrange
        Barber barber = new Barber();
        barber.setId(1);
        BarberResp expectedResp = modelMapper.map(barber, BarberResp.class);

        when(barberRepository.findById(1)).thenReturn(Optional.of(barber));

        // Act
        BarberResp result = barberService.getOne(1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }
}
