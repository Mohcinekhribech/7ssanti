package com.orcamo.hssanti.app.services.interfaces;

import com.orcamo.hssanti.app.dtos.request.ReservationReq;
import com.orcamo.hssanti.app.dtos.response.ReservationResp;
import com.orcamo.hssanti.shareable.CrudInterface;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationServiceInterface extends CrudInterface<ReservationReq, ReservationResp,Integer> {
    List<ReservationResp> getAllByClient(Integer client_id);
}
