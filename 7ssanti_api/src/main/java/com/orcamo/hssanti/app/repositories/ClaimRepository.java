package com.orcamo.hssanti.app.repositories;

import com.orcamo.hssanti.app.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim,Integer> {
}
