package com.orcamo.hssanti.app.dtos.request;

import lombok.Data;

@Data
public class ArticleReq {
    private Integer id;
    private String mediaLink;
    private String description;
    private Integer barber_id;
}
