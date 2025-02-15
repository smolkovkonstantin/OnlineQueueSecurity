package org.online.queue.onlinequeuesecurity.service;

import org.online.queue.onlinequeuesecurity.model.request.SignUpRequest;
import org.online.queue.onlinequeuesecurity.model.entity.Credentials;
import org.online.queue.onlinequeuesecurity.model.dto.SignInDto;

public interface CredentialsService {
    Credentials createCredentials(SignUpRequest signUpRequest);

    Credentials getCredentials(SignInDto signInDto);

    Credentials getCredentials(Long userId);

    Credentials getCredentials();
}
