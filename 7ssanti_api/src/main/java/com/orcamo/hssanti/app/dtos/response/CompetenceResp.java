package com.orcamo.hssanti.app.dtos.response;

import com.orcamo.hssanti.app.dtos.request.BarberReq;
import lombok.Data;

@Data
public class CompetenceResp {
    private Integer id;
    private String name;
    private String description;
    private BarberReq barber;
}
