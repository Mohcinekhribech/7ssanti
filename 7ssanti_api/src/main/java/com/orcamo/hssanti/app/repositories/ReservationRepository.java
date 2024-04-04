package com.orcamo.hssanti.app.repositories;

import com.orcamo.hssanti.app.entities.Client;
import com.orcamo.hssanti.app.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    List<Reservation> getAllByClient(Client client);
    List<Reservation> findByServices_barber_Id(Integer barberId);
}
