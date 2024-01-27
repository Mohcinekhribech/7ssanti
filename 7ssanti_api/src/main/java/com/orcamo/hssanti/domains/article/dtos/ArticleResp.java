package com.orcamo.hssanti.domains.article.dtos;

import com.orcamo.hssanti.domains.commment.dtos.CommentResp;
import com.orcamo.hssanti.domains.users.barber.dtos.BarberReq;
import com.orcamo.hssanti.domains.users.client.dtos.ClientReq;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ArticleResp {
    private Integer id;
    private String mediaLink;
    private String description;
    private BarberReq barber;
    private List<CommentResp> comments;
    private List<ClientReq> likes = new ArrayList<>();
}
