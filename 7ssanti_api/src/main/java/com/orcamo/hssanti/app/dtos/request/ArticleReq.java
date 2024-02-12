package com.orcamo.hssanti.app.dtos.request;

import lombok.Data;

import java.util.List;

@Data
public class ArticleReq {
    private Integer id;
    private String description;
    private Integer barber_id;
}
