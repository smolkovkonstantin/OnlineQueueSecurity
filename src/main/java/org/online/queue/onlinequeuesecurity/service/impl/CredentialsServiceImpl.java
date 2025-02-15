package org.online.queue.onlinequeuesecurity.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.online.queue.onlinequeuesecurity.enumeration.ErrorMessage;
import org.online.queue.onlinequeuesecurity.exception.ConflictException;
import org.online.queue.onlinequeuesecurity.exception.NotFoundException;
import org.online.queue.onlinequeuesecurity.model.request.SignUpRequest;
import org.online.queue.onlinequeuesecurity.model.entity.Credentials;
import org.online.queue.onlinequeuesecurity.model.dto.SignInDto;
import org.online.queue.onlinequeuesecurity.repository.CredentialsRepository;
import org.online.queue.onlinequeuesecurity.service.CredentialsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CredentialsServiceImpl implements CredentialsService {

    PasswordEncoder passwordEncoder;
    CredentialsRepository credentialsRepository;
    AuthenticationManager authenticationManager;

    @Override
    public Credentials createCredentials(SignUpRequest signUpRequest) {
        checkDuplicateEmail(signUpRequest.getEmail());
        var credentials = new Credentials();

        credentials.setEmail(signUpRequest.getEmail());
        credentials.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        credentials.setRole("TEST");

        return credentialsRepository.save(credentials);
    }

    void checkDuplicateEmail(String email) {
        credentialsRepository.findByEmail(email).ifPresent((credentials) -> {
            throw new ConflictException(ErrorMessage.DUPLICATE_EMAIL.createResponseModel());
        });
    }

    @Override
    public Credentials getCredentials(SignInDto signInDto) {
        var authToken = new UsernamePasswordAuthenticationToken(
                signInDto.getEmail(),
                signInDto.getPassword()
        );

        var authentication = authenticationManager
                .authenticate(authToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return (Credentials) authentication.getPrincipal();
    }

    @Override
    public Credentials getCredentials(Long userId) {
        return credentialsRepository.findById(userId).orElseThrow(() ->
                new NotFoundException(ErrorMessage.USER_NOT_FOUND_BY_ID.createResponseModel(userId)));
    }

    @Override
    public Credentials getCredentials() {
        return (Credentials) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
