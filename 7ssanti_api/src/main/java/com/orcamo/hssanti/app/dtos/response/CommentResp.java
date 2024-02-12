package com.orcamo.hssanti.app.dtos.response;

import lombok.Data;

@Data
public class CommentResp {
    private Integer id;
    private String content;
    private ClientResp client;
}
