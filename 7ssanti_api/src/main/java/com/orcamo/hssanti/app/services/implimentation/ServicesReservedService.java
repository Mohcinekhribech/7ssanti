package com.orcamo.hssanti.app.services.implimentation;


import com.orcamo.hssanti.app.entities.Reservation;
import com.orcamo.hssanti.app.repositories.ReservationRepository;
import com.orcamo.hssanti.app.repositories.ServiceRepository;
import com.orcamo.hssanti.app.services.interfaces.ServicesReservedInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServicesReservedService implements ServicesReservedInterface {
    private final ReservationRepository reservationRepository;
    private final ServiceRepository serviceRepository;
    @Override
    public void addServicetoReservation(Integer reservationId, Integer serviceId) {
        Reservation Reservation = reservationRepository.findById(reservationId).orElseThrow(EntityNotFoundException::new);
        com.orcamo.hssanti.app.entities.Service service = serviceRepository.findById(serviceId).orElseThrow(EntityNotFoundException::new);

        Reservation.getServices().add(service);
        service.getReservations().add(Reservation);

        reservationRepository.save(Reservation);
        serviceRepository.save(service);
    }

    @Override
    public void removeServiceFromReservation(Integer reservationId, Integer serviceId) {
        Reservation Reservation = reservationRepository.findById(reservationId).orElseThrow(EntityNotFoundException::new);
        com.orcamo.hssanti.app.entities.Service service = serviceRepository.findById(serviceId).orElseThrow(EntityNotFoundException::new);

        Reservation.getServices().remove(service);
        service.getReservations().remove(Reservation);

        reservationRepository.save(Reservation);
        serviceRepository.save(service);
    }
}
