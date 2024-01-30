package com.orcamo.hssanti.app.dtos.response;

import com.orcamo.hssanti.app.dtos.request.ArticleReq;
import lombok.Data;

@Data
public class CommentResp {
    private Integer id;
    private String content;
    private ArticleReq article;
    private ClientResp client;
}
