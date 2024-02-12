package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.ServiceReq;
import com.orcamo.hssanti.app.dtos.response.ServiceResp;
import com.orcamo.hssanti.app.entities.Barber;
import com.orcamo.hssanti.app.repositories.BarberRepository;
import com.orcamo.hssanti.app.repositories.ServiceRepository;
import com.orcamo.hssanti.app.services.interfaces.ServiceServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServiceService implements ServiceServiceInterface {
    private final ModelMapper modelMapper;
    private final ServiceRepository serviceRepository;
    private final BarberRepository barberRepository;

    @Override
    public ServiceResp create(ServiceReq serviceReq) {
        Optional<Barber> barber = barberRepository.findById(serviceReq.getBarber_id());
        return barber.map(b -> {
            com.orcamo.hssanti.app.entities.Service service = modelMapper.map(serviceReq, com.orcamo.hssanti.app.entities.Service.class);
            service.setBarber(b);
            return modelMapper.map(serviceRepository.save(service), ServiceResp.class);
        }).orElse(null);
    }

    @Override
    public ServiceResp update(ServiceReq serviceReq, Integer id) {
        Optional<com.orcamo.hssanti.app.entities.Service> serviceOptional = serviceRepository.findById(id);
        return serviceOptional.map(service -> {
            Optional<Barber> barber = barberRepository.findById(serviceReq.getBarber_id());
            return barber.map(b -> {
                com.orcamo.hssanti.app.entities.Service service1 = modelMapper.map(serviceReq, com.orcamo.hssanti.app.entities.Service.class);
                service1.setBarber(b);
                service1.setId(service.getId());
                return modelMapper.map(serviceRepository.save(service1), ServiceResp.class);
            }).orElse(null);
        }).orElse(null);
    }

    @Override
    public Integer delete(Integer id) {
        Optional<com.orcamo.hssanti.app.entities.Service> serviceOptional = serviceRepository.findById(id);
        return serviceOptional.map(hairSalon -> {
                    serviceRepository.delete(hairSalon);
                    return 1;
                })
                .orElse(0);
    }

    @Override
    public List<ServiceResp> getAll() {
        return serviceRepository.findAll().stream().map(service -> modelMapper.map(service, ServiceResp.class)).collect(Collectors.toList());
    }

    @Override
    public ServiceResp getOne(Integer id) {
        Optional<com.orcamo.hssanti.app.entities.Service> service = serviceRepository.findById(id);
        return modelMapper.map(service.orElse(null),ServiceResp.class);
    }
}
