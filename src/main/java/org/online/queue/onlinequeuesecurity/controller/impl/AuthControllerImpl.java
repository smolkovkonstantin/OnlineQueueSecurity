package org.online.queue.onlinequeuesecurity.controller.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.online.queue.onlinequeuesecurity.controller.AuthApi;
import org.online.queue.onlinequeuesecurity.enumeration.LogMessage;
import org.online.queue.onlinequeuesecurity.model.dto.SignInDto;
import org.online.queue.onlinequeuesecurity.model.request.RefreshRequest;
import org.online.queue.onlinequeuesecurity.model.request.SignInRequest;
import org.online.queue.onlinequeuesecurity.model.request.SignUpRequest;
import org.online.queue.onlinequeuesecurity.model.request.SingOutRequest;
import org.online.queue.onlinequeuesecurity.model.response.JwtResponse;
import org.online.queue.onlinequeuesecurity.model.response.SignInResponse;
import org.online.queue.onlinequeuesecurity.service.AuthService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthControllerImpl implements AuthApi {

    AuthService authService;

    static String REFRESH_TOKEN = "refresh_token";

    @Override
    public ResponseEntity<Void> signUp(SignUpRequest signUpRequest) {
        authService.signUp(signUpRequest);

        log.info(LogMessage.SIGN_UP.create());

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<SignInResponse> signIn(SignInRequest signInRequest) {

        var signInDto = SignInDto.builder()
                .email(signInRequest.getEmail())
                .password(signInRequest.getPassword())
                .deviceId(signInRequest.getDeviceId())
                .build();

        var signInResponse = buildResponseEntity(authService.signIn(signInDto));

        log.info(LogMessage.SIGN_IN.create(signInDto.getEmail()));

        return signInResponse;
    }

    @Override
    public ResponseEntity<Void> signOut(SingOutRequest singOutRequest) {
        return ResponseEntity.ok().build();
    }


    @Override
    public ResponseEntity<SignInResponse> refresh(RefreshRequest refreshRequest) {
        var jwtResponse = authService.updateToken(refreshRequest);

        log.info(LogMessage.UPDATE_TOKEN.create());

        return buildResponseEntity(jwtResponse);
    }

    private ResponseEntity<SignInResponse> buildResponseEntity(JwtResponse jwtResponse) {

        var headers = buildHttpHeaders(jwtResponse.getRefreshToken());
        var signInResponse = new SignInResponse(jwtResponse.getAccessToken());

        return ResponseEntity.ok()
                .headers(headers)
                .body(signInResponse);
    }

    private HttpHeaders buildHttpHeaders(String refreshToken) {

        var cookie = ResponseCookie.from(REFRESH_TOKEN, refreshToken)
                .httpOnly(true)
                .build();

        var headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, cookie.toString());

        return headers;
    }
}
