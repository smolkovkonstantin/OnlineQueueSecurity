package org.online.queue.onlinequeuesecurity.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JwtRequest(
        @JsonProperty("userId") Long userId,
        @JsonProperty("deviceId") String deviceId
) {
}
