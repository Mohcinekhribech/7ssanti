package com.orcamo.hssanti.app.dtos.request;

import lombok.Data;

@Data
public class RateReq {
    private Integer id;
    private Integer rate;
    private String note;
    private Integer client_id;
    private Integer barber_id;
}
