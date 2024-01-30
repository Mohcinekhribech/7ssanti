package com.orcamo.hssanti.app.repositories;

import com.orcamo.hssanti.app.entities.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends JpaRepository<Barber,Integer> {
}
