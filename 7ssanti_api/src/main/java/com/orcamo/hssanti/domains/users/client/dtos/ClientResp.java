package com.orcamo.hssanti.domains.users.client.dtos;

import com.orcamo.hssanti.security.User.DTOs.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientResp extends UserDTO {
    private LocalDate registrationDate;
}
