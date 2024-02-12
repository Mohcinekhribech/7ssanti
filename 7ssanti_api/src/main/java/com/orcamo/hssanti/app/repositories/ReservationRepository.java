package com.orcamo.hssanti.app.repositories;

import com.orcamo.hssanti.app.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
