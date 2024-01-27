package com.orcamo.hssanti.domains.users.barber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends JpaRepository<Barber,Integer> {
}
