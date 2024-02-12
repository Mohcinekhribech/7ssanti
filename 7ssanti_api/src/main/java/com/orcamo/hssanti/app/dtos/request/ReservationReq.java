package com.orcamo.hssanti.app.dtos.request;

import com.orcamo.hssanti.app.entities.ReservationEtat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationReq {
    private Integer id;
    private LocalDateTime date;
    private ReservationEtat etat;
    private Integer clientId;
}
