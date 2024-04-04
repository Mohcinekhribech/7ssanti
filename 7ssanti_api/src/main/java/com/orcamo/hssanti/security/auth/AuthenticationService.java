package com.orcamo.hssanti.security.auth;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.orcamo.hssanti.app.dtos.request.BarberReq;
import com.orcamo.hssanti.app.dtos.request.ClientReq;
import com.orcamo.hssanti.app.entities.Barber;
import com.orcamo.hssanti.app.entities.Client;
import com.orcamo.hssanti.app.repositories.BarberRepository;
import com.orcamo.hssanti.app.repositories.ClientRepository;
import com.orcamo.hssanti.security.User.DTOs.UserDTO;
import com.orcamo.hssanti.security.User.DTOs.UserRequest;
import com.orcamo.hssanti.security.User.Role;
import com.orcamo.hssanti.security.User.User;
import com.orcamo.hssanti.security.User.UserRepository;
import com.orcamo.hssanti.security.jwt.JwtService;
import com.orcamo.hssanti.security.token.Token;
import com.orcamo.hssanti.security.token.TokenRepository;
import com.orcamo.hssanti.security.token.TokenType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final BarberRepository barberRepository;
    private final ClientRepository clientRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;

    public AuthenticationResponse barberRegister(BarberReq request) {
        Barber barber = Barber.builder()
                .yearsOfExperience(request.getYearsOfExperience())
                .build();
        barber.setRole(Role.Barber);
        barber.setFullName(request.getFullName());
        barber.setEmail(request.getEmail());
        barber.setProfilePic(request.getProfilePic());
        barber.setDateOfBirth(request.getDateOfBirth());
        barber.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = barberRepository.save(barber);
        var jwtToken = jwtService.generateToken(barber);
        var refreshToken = jwtService.generateRefreshToken(barber);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .user(modelMapper.map(savedUser, UserDTO.class))
                .build();
    }

    public AuthenticationResponse clientBegister(ClientReq request) {
        Client client = Client.builder()
                .registrationDate(LocalDate.now())
                .build();
        client.setRole(Role.Client);
        client.setFullName(request.getFullName());
        client.setEmail(request.getEmail());
        client.setProfilePic(request.getProfilePic());
        client.setDateOfBirth(request.getDateOfBirth());
        client.setPassword(passwordEncoder.encode(request.getPassword()));
        var savedUser = clientRepository.save(client);
        var jwtToken = jwtService.generateToken(client);
        var refreshToken = jwtService.generateRefreshToken(client);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .user(modelMapper.map(savedUser, UserDTO.class))
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .user(modelMapper.map(user, UserDTO.class))
                .refreshToken(refreshToken)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String accessToken = authHeader.substring(7);
            String userEmail = jwtService.extractUsername(accessToken);
            if (userEmail != null) {
                User user = repository.findByEmail(userEmail).orElse(null);
                if (user != null) {
                    tokenRepository.deleteAllByUser(user);
                    response.setStatus(HttpServletResponse.SC_OK);
                    return;
                }
            }
        }
        // If no token found or user not found, return an error response
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}