package com.orcamo.hssanti.app.dtos.request;

import lombok.Data;

@Data
public class ServiceForReservationReq {
    private Integer id;
    private String name;
    private Integer timeIstimation;
    public BarberReq barber;
    private Integer price;
    private String description;
}
