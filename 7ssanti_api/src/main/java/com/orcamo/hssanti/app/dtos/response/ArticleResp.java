package com.orcamo.hssanti.app.dtos.response;

import com.orcamo.hssanti.app.dtos.request.BarberReq;
import com.orcamo.hssanti.app.dtos.request.ClientReq;
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