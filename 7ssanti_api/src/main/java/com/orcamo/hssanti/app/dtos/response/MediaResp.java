package com.orcamo.hssanti.app.dtos.response;

import com.orcamo.hssanti.app.entities.MediaType;
import com.orcamo.hssanti.security.User.DTOs.UserDTO;
import lombok.Data;

@Data
public class MediaResp {
    private Integer id;
    private String mediaLink;
    private MediaType type;
    public UserDTO user;
}
