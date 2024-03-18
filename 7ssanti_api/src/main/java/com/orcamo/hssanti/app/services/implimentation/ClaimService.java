package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.ClaimReq;
import com.orcamo.hssanti.app.dtos.response.ClaimResp;
import com.orcamo.hssanti.app.entities.Claim;
import com.orcamo.hssanti.security.User.User;
import com.orcamo.hssanti.app.repositories.ClaimRepository;
import com.orcamo.hssanti.security.User.UserRepository;
import com.orcamo.hssanti.app.services.interfaces.ClaimServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClaimService implements ClaimServiceInterface {
    private final ClaimRepository claimRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public ClaimResp create(ClaimReq claimReq) {
        Optional<User> userOptional = userRepository.findById(claimReq.getUser_id());
        return userOptional.map(user -> {
            Claim claim = modelMapper.map(claimReq, Claim.class);
            claim.setUser(user);
            claim = claimRepository.save(claim);
            return modelMapper.map(claim, ClaimResp.class);
        }).orElse(null);
    }

    @Override
    public ClaimResp update(ClaimReq claimReq, Integer id) {
        Optional<Claim> claimOptional = claimRepository.findById(id);

        return claimOptional.map(claimOpt -> {
            Optional<User> userOptional = userRepository.findById(claimReq.getId());

            return userOptional.map(user -> {
                Claim claim = modelMapper.map(claimReq, Claim.class);
                claim.setUser(user);
                claim.setId(claimOpt.getId());
                claim = claimRepository.save(claim);

                return modelMapper.map(claim, ClaimResp.class);
            }).orElse(null);
        }).orElse(null);
    }

    @Override
    public Integer delete(Integer id) {
        Optional<Claim> claimOptional = claimRepository.findById(id);
        return claimOptional.map(claim -> {
                    claimRepository.delete(claim);
                    return 1;
                })
                .orElse(0);
    }

    @Override
    public List<ClaimResp> getAll() {
        return claimRepository.findAll().stream().map(claim -> modelMapper.map(claim,ClaimResp.class)).collect(Collectors.toList());
    }

    @Override
    public ClaimResp getOne(Integer id) {
        Optional<Claim> claimOptional = claimRepository.findById(id);
        return modelMapper.map(claimOptional.orElse(null),ClaimResp.class);
    }
}
