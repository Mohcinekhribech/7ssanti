package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.RateReq;
import com.orcamo.hssanti.app.dtos.response.RateResp;
import com.orcamo.hssanti.app.entities.Client;
import com.orcamo.hssanti.app.entities.Rate;
import com.orcamo.hssanti.app.entities.Barber;
import com.orcamo.hssanti.app.repositories.ClientRepository;
import com.orcamo.hssanti.app.repositories.RateRepository;
import com.orcamo.hssanti.app.repositories.BarberRepository;
import com.orcamo.hssanti.app.services.interfaces.RateServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RateService implements RateServiceInterface {
    private final RateRepository rateRepository;
    private final BarberRepository barberRepository;
    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    @Override
    public RateResp create(RateReq rateReq) {
        if (rateReq.getRate() <= 5 && rateReq.getRate() >= 1) {
            Optional<Barber> barberOptional = barberRepository.findById(rateReq.getBarber_id());
            Optional<Client> clientOptional = clientRepository.findById(rateReq.getBarber_id());
            return barberOptional.flatMap(barber -> clientOptional.map(client -> {
                Rate rate = modelMapper.map(rateReq, Rate.class);
                rate.setBarber(barber);
                rate.setClient(client);
                rate = rateRepository.save(rate);
                return modelMapper.map(rate, RateResp.class);
            })).orElse(null);
        }
        return null;
    }

    @Override
    public RateResp update(RateReq rateReq, Integer id) {
        if (rateReq.getRate() <= 5 && rateReq.getRate() >= 1) {
            Optional<Rate> rateOptional = rateRepository.findById(id);

            return rateOptional.map(rateOpt -> {
                Optional<Barber> barberOptional = barberRepository.findById(rateReq.getId());
                Optional<Client> clientOptional = clientRepository.findById(rateReq.getBarber_id());

                return barberOptional.flatMap(barber -> clientOptional.map(client -> {
                    Rate rate = modelMapper.map(rateReq, Rate.class);
                    rate.setBarber(barber);
                    rate.setClient(client);
                    rate = rateRepository.save(rate);
                    return modelMapper.map(rate, RateResp.class);
                })).orElse(null);
            }).orElse(null);
        }
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        Optional<Rate> rateOptional = rateRepository.findById(id);
        return rateOptional.map(rate -> {
                    rateRepository.delete(rate);
                    return 1;
                })
                .orElse(0);
    }

    @Override
    public List<RateResp> getAll() {
        return rateRepository.findAll().stream().map(rate -> modelMapper.map(rate, RateResp.class)).collect(Collectors.toList());
    }

    @Override
    public RateResp getOne(Integer id) {
        Optional<Rate> rateOptional = rateRepository.findById(id);
        return modelMapper.map(rateOptional.orElse(null), RateResp.class);
    }
}
