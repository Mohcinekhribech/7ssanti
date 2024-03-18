package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.CompetenceReq;
import com.orcamo.hssanti.app.dtos.response.CompetenceResp;
import com.orcamo.hssanti.app.entities.Competence;
import com.orcamo.hssanti.app.entities.Barber;
import com.orcamo.hssanti.app.repositories.BarberRepository;
import com.orcamo.hssanti.app.repositories.CompetenceRepository;
import com.orcamo.hssanti.app.services.interfaces.CompetenceServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class CompetenceService implements CompetenceServiceInterface {
    private final CompetenceRepository competenceRepository;
    private final BarberRepository barberRepository;
    private final ModelMapper modelMapper;

    @Override
    public Boolean competenceVerified(Integer id) {
        Optional<Competence> competenceOptional = competenceRepository.findById(id);
        return competenceOptional.map(competence -> {
                competence.setVerified(true);
                competenceRepository.save(competence);
                return true;
        }).orElse(false);
    }

    @Override
    public CompetenceResp create(CompetenceReq competenceReq) {
        Optional<Barber> barberOptional = barberRepository.findById(competenceReq.getBarber_id());
        return barberOptional.map(barber -> {
            Competence competence = modelMapper.map(competenceReq, Competence.class);
            competence.setBarber(barber);
            competence = competenceRepository.save(competence);
            return modelMapper.map(competence, CompetenceResp.class);
        }).orElse(null);
    }

    @Override
    public CompetenceResp update(CompetenceReq competenceReq, Integer id) {
        Optional<Competence> competenceOptional = competenceRepository.findById(id);

        return competenceOptional.map(competenceOpt -> {
            Optional<Barber> barberOptional = barberRepository.findById(competenceReq.getId());

            return barberOptional.map(barber -> {
                Competence competence = modelMapper.map(competenceReq, Competence.class);
                competence.setBarber(barber);
                competence.setId(competenceOpt.getId());
                competence = competenceRepository.save(competence);

                return modelMapper.map(competence, CompetenceResp.class);
            }).orElse(null);
        }).orElse(null);
    }

    @Override
    public Integer delete(Integer id) {
        Optional<Competence> competenceOptional = competenceRepository.findById(id);
        return competenceOptional.map(competence -> {
                    competenceRepository.delete(competence);
                    return 1;
                })
                .orElse(0);
    }

    @Override
    public List<CompetenceResp> getAll() {
        return competenceRepository.findAll().stream().map(competence -> modelMapper.map(competence,CompetenceResp.class)).collect(Collectors.toList());
    }

    @Override
    public CompetenceResp getOne(Integer id) {
        Optional<Competence> competenceOptional = competenceRepository.findById(id);
        return modelMapper.map(competenceOptional.orElse(null),CompetenceResp.class);
    }
}
