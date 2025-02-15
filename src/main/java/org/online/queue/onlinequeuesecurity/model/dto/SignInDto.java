package org.online.queue.onlinequeuesecurity.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SignInDto {
    String email;
    String password;
    String deviceId;
}
