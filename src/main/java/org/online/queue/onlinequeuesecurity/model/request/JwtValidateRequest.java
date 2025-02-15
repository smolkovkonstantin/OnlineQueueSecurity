package org.online.queue.onlinequeuesecurity.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtValidateRequest {
    @JsonProperty("token")
    private String accessToken;
}
