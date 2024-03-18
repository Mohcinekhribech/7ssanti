package com.orcamo.hssanti.app.dtos.response;

import com.orcamo.hssanti.security.User.DTOs.UserDTO;
import lombok.Data;

@Data
public class ClaimResp {
    private Integer id;
    private String content;
    private UserDTO user;
}
