package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.HairSalonReq;
import com.orcamo.hssanti.app.dtos.response.HairSalonResp;
import com.orcamo.hssanti.app.entities.HairSalon;
import com.orcamo.hssanti.app.repositories.HairSalonRepository;
import com.orcamo.hssanti.app.services.interfaces.HairSalonServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HairSalonService implements HairSalonServiceInterface {
    private final HairSalonRepository hairSalonRepository;
    private final ModelMapper modelMapper;
    @Override
    public HairSalonResp create(HairSalonReq hairSalonReq) {
        HairSalon hairSalon =  hairSalonRepository.save(modelMapper.map(hairSalonReq,HairSalon.class));
        return modelMapper.map(hairSalon, HairSalonResp.class);
    }

    @Override
    public HairSalonResp update(HairSalonReq hairSalonReq, Integer id) {
        Optional<HairSalon> hairSalonOptional = hairSalonRepository.findById(id);
        return hairSalonOptional.map(hairSalon -> {
            hairSalonReq.setId(hairSalon.getId());
            hairSalon = hairSalonRepository.save(modelMapper.map(hairSalonReq,HairSalon.class));
            return modelMapper.map(hairSalon,HairSalonResp.class);
        }).orElse(null);
    }

    @Override
    public Integer delete(Integer id) {
        Optional<HairSalon> hairSalonOptional = hairSalonRepository.findById(id);
        return hairSalonOptional.map(hairSalon -> {
                    hairSalonRepository.delete(hairSalon);
                    return 1;
                })
                .orElse(0);
    }

    @Override
    public List<HairSalonResp> getAll() {
        return hairSalonRepository.findAll().stream().map(hairSalon -> modelMapper.map(hairSalon,HairSalonResp.class)).collect(Collectors.toList());
    }

    @Override
    public HairSalonResp getOne(Integer id) {
        Optional<HairSalon> hairSalonOptional = hairSalonRepository.findById(id);
        return modelMapper.map(hairSalonOptional.orElse(null),HairSalonResp.class);
    }
}
