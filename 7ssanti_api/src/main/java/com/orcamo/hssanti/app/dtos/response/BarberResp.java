package com.orcamo.hssanti.app.dtos.response;

import com.orcamo.hssanti.security.User.DTOs.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BarberResp extends UserDTO {
    private  Integer yearsOfExperience;

}
