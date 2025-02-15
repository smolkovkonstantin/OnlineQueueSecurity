package org.online.queue.onlinequeuesecurity.client;

import org.online.queue.onlinequeuesecurity.model.request.JwtRequest;
import org.online.queue.onlinequeuesecurity.model.request.JwtUpdateRequest;
import org.online.queue.onlinequeuesecurity.model.request.JwtValidateRequest;
import org.online.queue.onlinequeuesecurity.model.response.JwtResponse;
import org.online.queue.onlinequeuesecurity.model.response.JwtValidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "jwt-client")
public interface JwtClientService {

    @PostMapping(path = "/token")
    ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequest jwtRequest);

    @PostMapping(path = "/validation")
    ResponseEntity<JwtValidateResponse> validateToken(@RequestBody JwtValidateRequest jwtValidateRequest);

    @PutMapping(path = "/token")
    ResponseEntity<JwtResponse> updateToken(@RequestBody JwtUpdateRequest jwtRequest);
}
