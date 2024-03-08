package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.dtos.request.ReservationReq;
import com.orcamo.hssanti.app.dtos.response.ReservationResp;
import com.orcamo.hssanti.app.services.interfaces.ReservationServiceInterface;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController extends CrudController<ReservationReq, ReservationResp ,Integer , ReservationServiceInterface> {
    public ReservationController(ReservationServiceInterface reservationServiceInterface, ResponseMessage responseMessage) {
        super(reservationServiceInterface, responseMessage);
    }
    @PutMapping("/client/{id}")
    public List<ReservationResp> getAllByClient(@PathVariable Integer id)
    {
       return this.service.getAllByClient(id);
    }
}
