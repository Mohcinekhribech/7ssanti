package com.orcamo.hssanti.app.dtos.request;

import com.orcamo.hssanti.app.entities.MediaType;
import com.orcamo.hssanti.security.User.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class MediaReq {
    private Integer id;
    private String mediaLink;
    private MediaType type;
    private Integer article_id;
}
