package org.online.queue.onlinequeuesecurity.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JwtValidateResponse(
        @JsonProperty("userId") Long userId
) {
}
