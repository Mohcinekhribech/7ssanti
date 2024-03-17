package com.orcamo.hssanti.app.dtos.response;

import com.orcamo.hssanti.app.dtos.request.ClientReq;
import com.orcamo.hssanti.app.dtos.request.ServiceForReservationReq;
import com.orcamo.hssanti.app.dtos.request.ServiceReq;
import com.orcamo.hssanti.app.entities.ReservationEtat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class ReservationResp {
    private Integer id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer price ;
    private ReservationEtat etat;
    private List<ServiceForReservationReq> services ;
    private ClientReq client;
}