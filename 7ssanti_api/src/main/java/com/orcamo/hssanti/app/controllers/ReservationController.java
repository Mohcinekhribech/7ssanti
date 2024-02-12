package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.dtos.request.ReservationReq;
import com.orcamo.hssanti.app.dtos.response.ReservationResp;
import com.orcamo.hssanti.app.services.interfaces.ReservationServiceInterface;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;

public class ReservationController extends CrudController<ReservationReq, ReservationResp ,Integer , ReservationServiceInterface> {
    public ReservationController(ReservationServiceInterface reservationServiceInterface, ResponseMessage responseMessage) {
        super(reservationServiceInterface, responseMessage);
    }
}
