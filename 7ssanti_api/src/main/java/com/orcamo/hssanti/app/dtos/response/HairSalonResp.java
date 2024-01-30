package com.orcamo.hssanti.app.dtos.response;

import com.orcamo.hssanti.app.dtos.request.BarberReq;
import lombok.Data;

import java.util.List;
@Data
public class HairSalonResp {
    private Integer id;
    private String name;
    private String location;
    private List<BarberReq> barbers;
}
