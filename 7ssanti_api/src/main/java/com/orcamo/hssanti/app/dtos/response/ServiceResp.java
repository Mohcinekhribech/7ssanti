package com.orcamo.hssanti.app.dtos.response;

import com.orcamo.hssanti.app.dtos.request.BarberReq;
import com.orcamo.hssanti.app.dtos.request.ReservationReq;
import lombok.Data;

import java.util.List;

@Data
public class ServiceResp {
    private Integer id;
    private String name;
    private Integer timeIstimation;
    public BarberReq barber;
    private Integer price;
    private String description;
    private List<ReservationReq> reservations;
}
