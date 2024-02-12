package com.orcamo.hssanti.app.dtos.response;

import com.orcamo.hssanti.app.dtos.request.BarberReq;
import com.orcamo.hssanti.app.dtos.request.ClientReq;
import com.orcamo.hssanti.app.dtos.request.MediaReq;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ArticleForBarberResp {
    private Integer id;
    private String mediaLink;
    private String description;
    private List<CommentResp> comments;
    private List<MediaReq> medias;
    private List<ClientReq> likes = new ArrayList<>();
}
