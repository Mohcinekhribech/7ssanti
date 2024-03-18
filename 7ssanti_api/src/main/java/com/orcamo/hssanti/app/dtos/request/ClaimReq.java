package com.orcamo.hssanti.app.dtos.request;

import lombok.Data;

@Data
public class ClaimReq {
    private Integer id;
    private String content;
    private Integer user_id;
}
