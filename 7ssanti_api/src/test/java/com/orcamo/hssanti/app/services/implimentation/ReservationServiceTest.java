package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.ReservationReq;
import com.orcamo.hssanti.app.dtos.response.ReservationResp;
import com.orcamo.hssanti.app.entities.Client;
import com.orcamo.hssanti.app.entities.Reservation;
import com.orcamo.hssanti.app.entities.ReservationEtat;
import com.orcamo.hssanti.app.repositories.ClientRepository;
import com.orcamo.hssanti.app.repositories.ReservationRepository;
import com.orcamo.hssanti.app.services.implimentation.ReservationService;
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

class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ReservationService reservationService;

    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        modelMapper = new ModelMapper();
        reservationService = new ReservationService(reservationRepository, clientRepository, modelMapper);
    }

    @Test
    void testCreate() {
        // Arrange
        Client client = new Client();
        client.setId(1);
        ReservationReq reservationReq = new ReservationReq();
        reservationReq.setClientId(1);
        Reservation reservation = modelMapper.map(reservationReq, Reservation.class);
        reservation.setClient(client);
        ReservationResp expectedResp = modelMapper.map(reservation, ReservationResp.class);

        when(clientRepository.findById(1)).thenReturn(Optional.of(client));
        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);

        // Act
        ReservationResp result = reservationService.create(reservationReq);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testUpdate() {
        // Arrange
        Client client = new Client();
        client.setId(1);
        Reservation existingReservation = new Reservation();
        existingReservation.setId(1);
        ReservationReq reservationReq = new ReservationReq();
        reservationReq.setClientId(1);
        Reservation updatedReservation = modelMapper.map(reservationReq, Reservation.class);
        updatedReservation.setClient(client);
        updatedReservation.setId(1);
        ReservationResp expectedResp = modelMapper.map(updatedReservation, ReservationResp.class);

        when(reservationRepository.findById(1)).thenReturn(Optional.of(existingReservation));
        when(clientRepository.findById(1)).thenReturn(Optional.of(client));
        when(reservationRepository.save(any(Reservation.class))).thenReturn(updatedReservation);

        // Act
        ReservationResp result = reservationService.update(reservationReq, 1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testDelete() {
        // Arrange
        Reservation reservation = new Reservation();
        reservation.setId(1);

        when(reservationRepository.findById(1)).thenReturn(Optional.of(reservation));

        // Act
        Integer result = reservationService.delete(1);

        // Assert
        assertEquals(1, result);
        verify(reservationRepository, times(1)).delete(reservation);
    }

    @Test
    void testGetAll() {
        // Arrange
        Reservation reservation1 = new Reservation();
        Reservation reservation2 = new Reservation();
        List<Reservation> reservations = Arrays.asList(reservation1, reservation2);
        List<ReservationResp> expectedResp = reservations.stream()
                .map(r -> modelMapper.map(r, ReservationResp.class))
                .toList();

        when(reservationRepository.findAll()).thenReturn(reservations);

        // Act
        List<ReservationResp> result = reservationService.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testGetOne() {
        // Arrange
        Reservation reservation = new Reservation();
        reservation.setId(1);
        ReservationResp expectedResp = modelMapper.map(reservation, ReservationResp.class);

        when(reservationRepository.findById(1)).thenReturn(Optional.of(reservation));

        // Act
        ReservationResp result = reservationService.getOne(1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testGetAllByClient() {
        // Arrange
        Client client = new Client();
        client.setId(1);
        Reservation reservation1 = new Reservation();
        reservation1.setClient(client);
        Reservation reservation2 = new Reservation();
        reservation2.setClient(client);
        List<Reservation> reservations = Arrays.asList(reservation1, reservation2);
        List<ReservationResp> expectedResp = reservations.stream()
                .map(r -> modelMapper.map(r, ReservationResp.class))
                .toList();

        when(clientRepository.findById(1)).thenReturn(Optional.of(client));
        when(reservationRepository.getAllByClient(client)).thenReturn(reservations);

        // Act
        List<ReservationResp> result = reservationService.getAllByClient(1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testGetAllByBarber() {
        // Arrange
        Reservation reservation1 = new Reservation();
        Reservation reservation2 = new Reservation();
        List<Reservation> reservations = Arrays.asList(reservation1, reservation2);
        List<ReservationResp> expectedResp = reservations.stream()
                .map(r -> modelMapper.map(r, ReservationResp.class))
                .toList();

        when(reservationRepository.findByServices_barber_Id(1)).thenReturn(reservations);

        // Act
        List<ReservationResp> result = reservationService.getAllByBarber(1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testPassedReservation() {
        // Arrange
        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setEtat(ReservationEtat.PENDING);

        when(reservationRepository.findById(1)).thenReturn(Optional.of(reservation));

        // Act
        boolean result = reservationService.passedReservation(1);

        // Assert
        assertTrue(result);
        assertEquals(ReservationEtat.PASSED, reservation.getEtat());
        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    void testNotPassedReservation() {
        // Arrange
        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setEtat(ReservationEtat.PENDING);

        when(reservationRepository.findById(1)).thenReturn(Optional.of(reservation));

        // Act
        boolean result = reservationService.notPassedReservation(1);

        // Assert
        assertTrue(result);
        assertEquals(ReservationEtat.NOT_PASSED, reservation.getEtat());
        verify(reservationRepository, times(1)).save(reservation);
    }
}