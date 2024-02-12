package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.ReservationReq;
import com.orcamo.hssanti.app.dtos.response.ReservationResp;
import com.orcamo.hssanti.app.dtos.response.ServiceResp;
import com.orcamo.hssanti.app.entities.Barber;
import com.orcamo.hssanti.app.entities.Client;
import com.orcamo.hssanti.app.entities.Reservation;
import com.orcamo.hssanti.app.repositories.ClientRepository;
import com.orcamo.hssanti.app.repositories.ReservationRepository;
import com.orcamo.hssanti.app.services.interfaces.ReservationServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationService implements ReservationServiceInterface {
    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    @Override
    public ReservationResp create(ReservationReq reservationReq) {
        Optional<Client> client = clientRepository.findById(reservationReq.getClientId());
        return client.map(c -> {
            Reservation reservation = modelMapper.map(reservationReq, Reservation.class);
            reservation.setClient(c);
            return modelMapper.map(reservationRepository.save(reservation), ReservationResp.class);
        }).orElse(null);
    }

    @Override
    public ReservationResp update(ReservationReq reservationReq, Integer id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.map(reservation -> {
            Optional<Client> client = clientRepository.findById(reservationReq.getClientId());
            return client.map(c -> {
                Reservation reservation1 = modelMapper.map(reservationReq, Reservation.class);
                reservation1.setClient(c);
                reservation1.setId(reservation.getId());
                return modelMapper.map(reservationRepository.save(reservation1), ReservationResp.class);
            }).orElse(null);
        }).orElse(null);
    }

    @Override
    public Integer delete(Integer id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.map(reservation -> {
                    reservationRepository.delete(reservation);
                    return 1;
                })
                .orElse(0);
    }

    @Override
    public List<ReservationResp> getAll() {
        return reservationRepository.findAll().stream().map(reservation -> modelMapper.map(reservation,ReservationResp.class)).collect(Collectors.toList());
    }

    @Override
    public ReservationResp getOne(Integer id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return modelMapper.map(reservationOptional.orElse(null),ReservationResp.class);
    }
}
