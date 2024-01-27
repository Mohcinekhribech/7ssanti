package com.orcamo.hssanti.domains.hairSalon.dtos;

import com.orcamo.hssanti.domains.users.barber.dtos.BarberReq;
import lombok.Data;

import java.util.List;
@Data
public class HairSalonResp {
    private Integer id;
    private String name;
    private String location;
    private List<BarberReq> barbers;
}
