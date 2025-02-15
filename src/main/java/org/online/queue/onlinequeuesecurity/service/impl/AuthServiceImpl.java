package org.online.queue.onlinequeuesecurity.service.impl;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.online.queue.onlinequeuesecurity.model.response.JwtResponse;
import org.online.queue.onlinequeuesecurity.model.request.RefreshRequest;
import org.online.queue.onlinequeuesecurity.model.request.SignUpRequest;
import org.online.queue.onlinequeuesecurity.model.entity.Credentials;
import org.online.queue.onlinequeuesecurity.model.dto.CreateAccountDto;
import org.online.queue.onlinequeuesecurity.model.request.JwtRequest;
import org.online.queue.onlinequeuesecurity.model.request.JwtUpdateRequest;
import org.online.queue.onlinequeuesecurity.model.dto.SignInDto;
import org.online.queue.onlinequeuesecurity.service.AuthService;
import org.online.queue.onlinequeuesecurity.service.CredentialsService;
import org.online.queue.onlinequeuesecurity.service.JwtService;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    CredentialsService credentialsService;
    JwtService jwtService;

    @Override
    @Transactional
    public void signUp(SignUpRequest signUpRequest) {

        var credentials=  credentialsService.createCredentials(signUpRequest);

        createAccount(signUpRequest, credentials);
    }

    private void createAccount(SignUpRequest signUpRequest, Credentials credentials) {
        var createAccountDto = CreateAccountDto.builder()
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .username(signUpRequest.getUsername())
                .credentials(credentials)
                .build();
    }

    @Override
    public JwtResponse signIn(SignInDto signInDto) {

        var credentials = credentialsService.getCredentials(signInDto);

        var jwtCreateRequest = new JwtRequest(credentials.getId(), signInDto.getDeviceId());

        return jwtService.createToken(jwtCreateRequest);
    }

    @Override
    public JwtResponse updateToken(RefreshRequest refreshRequest) {
        var jwtupdateRequest = new JwtUpdateRequest(refreshRequest.getRefreshToken(), refreshRequest.getDeviceId());

        return jwtService.updateToken(jwtupdateRequest);
    }
}
