package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.BarberReq;
import com.orcamo.hssanti.app.dtos.response.BarberResp;
import com.orcamo.hssanti.app.entities.Barber;
import com.orcamo.hssanti.app.repositories.BarberRepository;
import com.orcamo.hssanti.app.services.interfaces.BarberServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BarberService implements BarberServiceInterface {
    private final BarberRepository barberRepository;
    private final ModelMapper modelMapper;
    @Override
    public BarberResp create(BarberReq barberReq) {
        Barber barber =  barberRepository.save(modelMapper.map(barberReq,Barber.class));
        return modelMapper.map(barber,BarberResp.class);
    }

    @Override
    public BarberResp update(BarberReq barberReq, Integer id) {
        Optional<Barber> barberOptional = barberRepository.findById(id);
        return barberOptional.map(barber -> {
            barberReq.setId(barber.getId());
            barber = barberRepository.save(modelMapper.map(barberReq,Barber.class));
            return modelMapper.map(barber,BarberResp.class);
        }).orElse(null);
    }

    @Override
    public Integer delete(Integer id) {
        Optional<Barber> barberOptional = barberRepository.findById(id);
        return barberOptional.map(barber -> {
                    barberRepository.delete(barber);
                    return 1;
                })
                .orElse(0);
    }

    @Override
    public List<BarberResp> getAll() {
        return barberRepository.findAll().stream().map(barber -> modelMapper.map(barber,BarberResp.class)).collect(Collectors.toList());
    }

    @Override
    public BarberResp getOne(Integer id) {
        Optional<Barber> barberOptional = barberRepository.findById(id);
        return modelMapper.map(barberOptional.orElse(null),BarberResp.class);
    }
}
