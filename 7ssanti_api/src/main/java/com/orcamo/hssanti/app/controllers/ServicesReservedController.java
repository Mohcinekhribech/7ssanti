package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.services.implimentation.ServicesReservedService;
import com.orcamo.hssanti.shareable.ResponseMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reserve/service")
@AllArgsConstructor
public class ServicesReservedController {
    private final ServicesReservedService servicesReservedService;
    private final ResponseMessage responseMessage;
    @PostMapping("/{reservationId}/{serviceId}")
    public ResponseEntity<ResponseMessage> addLiketoAnArticle(@PathVariable Integer reservationId, @PathVariable Integer serviceId)
    {
        servicesReservedService.addServicetoReservation(reservationId,serviceId);
        responseMessage.setMessage("service reserved");
        return ResponseEntity.ok().body(responseMessage);
    }
    @DeleteMapping("/{reservationId}/{serviceId}")
    public ResponseEntity<ResponseMessage> removeLikeFromAPost(@PathVariable Integer reservationId, @PathVariable Integer serviceId)
    {
        servicesReservedService.removeServiceFromReservation(reservationId,serviceId);
        responseMessage.setMessage("service removed from reservation");
        return ResponseEntity.ok().body(responseMessage);
    }
}