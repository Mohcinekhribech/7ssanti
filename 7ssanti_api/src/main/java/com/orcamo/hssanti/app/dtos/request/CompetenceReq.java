package com.orcamo.hssanti.app.dtos.request;

import lombok.Data;

@Data
public class CompetenceReq {
    private Integer id;
    private String name;
    private String description;
    private Integer barber_id;
}
