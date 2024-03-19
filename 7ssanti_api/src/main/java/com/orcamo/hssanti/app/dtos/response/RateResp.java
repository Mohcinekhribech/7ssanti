package com.orcamo.hssanti.app.dtos.response;

import com.orcamo.hssanti.app.dtos.request.BarberReq;
import com.orcamo.hssanti.app.dtos.request.ClientReq;
import lombok.Data;

@Data
public class RateResp {
    private Integer id;
    private Integer rate;
    private String note;
    private ClientReq client;
}
