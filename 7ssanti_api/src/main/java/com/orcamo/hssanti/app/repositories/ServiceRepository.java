package com.orcamo.hssanti.app.repositories;

import com.orcamo.hssanti.app.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
}
