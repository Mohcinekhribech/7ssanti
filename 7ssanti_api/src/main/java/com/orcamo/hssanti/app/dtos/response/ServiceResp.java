package com.orcamo.hssanti.app.dtos.response;

import com.orcamo.hssanti.app.dtos.request.BarberReq;
import lombok.Data;

@Data
public class ServiceResp {
    private Integer id;
    private String name;
    private Integer timeIstimation;
    public BarberReq barber;
}
