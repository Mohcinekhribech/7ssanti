package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.ReservationReq;
import com.orcamo.hssanti.app.dtos.response.ReservationResp;
import com.orcamo.hssanti.app.entities.Reservation;
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
    private final ModelMapper modelMapper;

    @Override
    public ReservationResp create(ReservationReq reservationReq) {
        Reservation reservation =  reservationRepository.save(modelMapper.map(reservationReq,Reservation.class));
        return modelMapper.map(reservation, ReservationResp.class);
    }

    @Override
    public ReservationResp update(ReservationReq reservationReq, Integer id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.map(reservation -> {
            reservationReq.setId(reservation.getId());
            reservation = reservationRepository.save(modelMapper.map(reservationReq,Reservation.class));
            return modelMapper.map(reservation,ReservationResp.class);
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
