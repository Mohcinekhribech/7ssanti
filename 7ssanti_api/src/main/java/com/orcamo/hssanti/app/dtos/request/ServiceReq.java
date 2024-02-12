package com.orcamo.hssanti.app.dtos.request;

import lombok.Data;

@Data
public class ServiceReq {
    private Integer id;
    private String name;
    private Integer timeIstimation;
    public Integer barber_id;
}
