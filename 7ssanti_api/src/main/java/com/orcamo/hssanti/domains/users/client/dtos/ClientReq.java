package com.orcamo.hssanti.domains.users.client.dtos;

import com.orcamo.hssanti.security.User.DTOs.UserRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientReq extends UserRequest {
    private LocalDate registrationDate;
}
