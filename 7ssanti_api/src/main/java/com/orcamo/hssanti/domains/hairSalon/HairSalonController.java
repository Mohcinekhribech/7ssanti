package com.orcamo.hssanti.domains.hairSalon;

import com.orcamo.hssanti.domains.hairSalon.dtos.HairSalonReq;
import com.orcamo.hssanti.domains.hairSalon.dtos.HairSalonResp;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import lombok.experimental.SuperBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hair-salon")
public class HairSalonController extends CrudController<HairSalonReq, HairSalonResp,Integer,HairSalonServiceInterface> {
    public HairSalonController(HairSalonServiceInterface hairSalonServiceInterface, ResponseMessage responseMessage) {
        super(hairSalonServiceInterface, responseMessage);
    }
}
