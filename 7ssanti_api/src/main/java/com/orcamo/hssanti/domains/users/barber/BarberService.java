package com.orcamo.hssanti.domains.users.barber;

import com.orcamo.hssanti.domains.users.barber.dtos.BarberReq;
import com.orcamo.hssanti.domains.users.barber.dtos.BarberResp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BarberService implements BarberServiceInterface{
    private final BarberRepository barberRepository;
    @Override
    public BarberResp create(BarberReq barberReq) {
        return null;
    }

    @Override
    public BarberResp update(BarberReq barberReq, Integer integer) {
        return null;
    }

    @Override
    public Integer delete(Integer integer) {
        return null;
    }

    @Override
    public List<BarberResp> getAll() {
        return null;
    }

    @Override
    public BarberResp getOne(Integer integer) {
        return null;
    }
}
