package com.orcamo.hssanti.domains.commment.dtos;

import com.orcamo.hssanti.domains.article.dtos.ArticleReq;
import com.orcamo.hssanti.domains.users.client.dtos.ClientResp;
import lombok.Data;

@Data
public class CommentResp {
    private Integer id;
    private String content;
    private ArticleReq article;
    private ClientResp client;
}
