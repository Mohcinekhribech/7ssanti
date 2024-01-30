package com.orcamo.hssanti.app.dtos.request;


import lombok.Data;

@Data
public class CommentReq {
    private Integer id;
    private String content;
    private Integer article_id;
    private Integer client_id;
}
