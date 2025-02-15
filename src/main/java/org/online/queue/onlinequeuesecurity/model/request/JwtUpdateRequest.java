package org.online.queue.onlinequeuesecurity.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JwtUpdateRequest(
        @JsonProperty("token") String refreshToken,
        @JsonProperty("deviceId") String deviceId
) {
}
