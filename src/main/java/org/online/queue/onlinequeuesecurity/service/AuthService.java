package org.online.queue.onlinequeuesecurity.service;

import org.online.queue.onlinequeuesecurity.model.response.JwtResponse;
import org.online.queue.onlinequeuesecurity.model.request.RefreshRequest;
import org.online.queue.onlinequeuesecurity.model.request.SignUpRequest;
import org.online.queue.onlinequeuesecurity.model.dto.SignInDto;

public interface AuthService {

    void signUp(SignUpRequest signUpRequest);

    JwtResponse signIn(SignInDto signInResponse);

    JwtResponse updateToken(RefreshRequest refreshRequest);
}
