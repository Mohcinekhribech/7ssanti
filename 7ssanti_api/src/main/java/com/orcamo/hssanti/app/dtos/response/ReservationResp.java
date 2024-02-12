package com.orcamo.hssanti.app.dtos.response;

import com.orcamo.hssanti.app.dtos.request.ClientReq;
import com.orcamo.hssanti.app.dtos.request.ServiceReq;
import com.orcamo.hssanti.app.entities.ReservationEtat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ReservationResp {
    private Integer id;
    private LocalDateTime date;
    private ReservationEtat etat;
    private List<ServiceReq> services ;
    private ClientReq client;
}
