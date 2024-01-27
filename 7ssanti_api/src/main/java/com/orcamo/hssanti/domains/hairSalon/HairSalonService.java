package com.orcamo.hssanti.domains.hairSalon;

import com.orcamo.hssanti.domains.hairSalon.dtos.HairSalonReq;
import com.orcamo.hssanti.domains.hairSalon.dtos.HairSalonResp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HairSalonService implements HairSalonServiceInterface{
    @Override
    public HairSalonResp create(HairSalonReq hairSalonReq) {
        return null;
    }

    @Override
    public HairSalonResp update(HairSalonReq hairSalonReq, Integer integer) {
        return null;
    }

    @Override
    public Integer delete(Integer integer) {
        return null;
    }

    @Override
    public List<HairSalonResp> getAll() {
        return null;
    }

    @Override
    public HairSalonResp getOne(Integer integer) {
        return null;
    }
}
