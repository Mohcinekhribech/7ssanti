package com.orcamo.hssanti.domains.users.barber.dtos;

import com.orcamo.hssanti.security.User.DTOs.UserRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BarberReq extends UserRequest {
    private  Integer yearsOfExperience;
}
