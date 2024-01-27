package com.orcamo.hssanti.domains.users.barber.dtos;

import com.orcamo.hssanti.security.User.DTOs.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BarberResp extends UserDTO {
    private  Integer yearsOfExperience;

}
