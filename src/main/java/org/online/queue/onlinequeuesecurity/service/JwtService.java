package org.online.queue.onlinequeuesecurity.service;

import org.online.queue.onlinequeuesecurity.model.response.JwtResponse;
import org.online.queue.onlinequeuesecurity.model.request.JwtRequest;
import org.online.queue.onlinequeuesecurity.model.request.JwtUpdateRequest;
import org.online.queue.onlinequeuesecurity.model.request.JwtValidateRequest;
import org.online.queue.onlinequeuesecurity.model.response.JwtValidateResponse;

public interface JwtService {
    JwtResponse createToken(JwtRequest jwtCreateRequest);

    JwtResponse updateToken(JwtUpdateRequest jwtupdateRequest);

    JwtValidateResponse validateToken(JwtValidateRequest jwtValidateRequest);
}
