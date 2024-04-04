package com.orcamo.hssanti.security.auth;

import com.orcamo.hssanti.app.dtos.request.BarberReq;
import com.orcamo.hssanti.app.dtos.request.ClientReq;
import com.orcamo.hssanti.security.User.DTOs.UserRequest;
import com.orcamo.hssanti.shareable.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;
    private final ResponseMessage responseMessage;

    @PostMapping("/register-client")
    public ResponseEntity<AuthenticationResponse> clientRegister(
            @RequestBody ClientReq request
    ) {
        return ResponseEntity.ok(service.clientBegister(request));
    }
    @PostMapping("/register-barber")
    public ResponseEntity<AuthenticationResponse> barberRegister(
            @RequestBody BarberReq request
    ) {
        return ResponseEntity.ok(service.barberRegister(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }

    @PostMapping("/logout")
    public ResponseEntity<ResponseMessage> logout(HttpServletRequest request, HttpServletResponse response) {
        // Invalidate JWT token by removing it from client-side storage
        service.logout(request,response);
        responseMessage.setMessage("Logout successful");
        return ResponseEntity.ok(responseMessage);
    }

}