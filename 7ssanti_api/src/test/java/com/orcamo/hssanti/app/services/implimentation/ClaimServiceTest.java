package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.ClaimReq;
import com.orcamo.hssanti.app.dtos.response.ClaimResp;
import com.orcamo.hssanti.app.entities.Claim;
import com.orcamo.hssanti.security.User.User;
import com.orcamo.hssanti.app.repositories.ClaimRepository;
import com.orcamo.hssanti.security.User.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClaimServiceTest {

    @Mock
    private ClaimRepository claimRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ClaimService claimService;

    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        modelMapper = new ModelMapper();
        claimService = new ClaimService(claimRepository, userRepository, modelMapper);
    }

    @Test
    void testCreate() {
        // Arrange
        User user = new User();
        user.setId(1);
        ClaimReq claimReq = new ClaimReq();
        claimReq.setUser_id(1);
        Claim claim = modelMapper.map(claimReq, Claim.class);
        claim.setUser(user);
        ClaimResp expectedResp = modelMapper.map(claim, ClaimResp.class);

        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(claimRepository.save(any(Claim.class))).thenReturn(claim);

        // Act
        ClaimResp result = claimService.create(claimReq);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testUpdate() {
        // Arrange
        User user = new User();
        user.setId(1);
        Claim existingClaim = new Claim();
        existingClaim.setId(1);
        ClaimReq claimReq = new ClaimReq();
        claimReq.setId(1);
        claimReq.setUser_id(1);
        Claim updatedClaim = modelMapper.map(claimReq, Claim.class);
        updatedClaim.setUser(user);
        updatedClaim.setId(1);
        ClaimResp expectedResp = modelMapper.map(updatedClaim, ClaimResp.class);

        when(claimRepository.findById(1)).thenReturn(Optional.of(existingClaim));
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(claimRepository.save(any(Claim.class))).thenReturn(updatedClaim);

        // Act
        ClaimResp result = claimService.update(claimReq, 1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testDelete() {
        // Arrange
        Claim claim = new Claim();
        claim.setId(1);

        when(claimRepository.findById(1)).thenReturn(Optional.of(claim));

        // Act
        Integer result = claimService.delete(1);

        // Assert
        assertEquals(1, result);
        verify(claimRepository, times(1)).delete(claim);
    }

    @Test
    void testGetAll() {
        // Arrange
        Claim claim1 = new Claim();
        Claim claim2 = new Claim();
        List<Claim> claims = Arrays.asList(claim1, claim2);
        List<ClaimResp> expectedResp = claims.stream()
                .map(c -> modelMapper.map(c, ClaimResp.class))
                .toList();

        when(claimRepository.findAll()).thenReturn(claims);

        // Act
        List<ClaimResp> result = claimService.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testGetOne() {
        // Arrange
        Claim claim = new Claim();
        claim.setId(1);
        ClaimResp expectedResp = modelMapper.map(claim, ClaimResp.class);

        when(claimRepository.findById(1)).thenReturn(Optional.of(claim));

        // Act
        ClaimResp result = claimService.getOne(1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }
}