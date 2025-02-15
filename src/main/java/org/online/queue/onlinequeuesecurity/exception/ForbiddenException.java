package org.online.queue.onlinequeuesecurity.exception;

import lombok.Getter;
import org.online.queue.onlinequeuesecurity.model.response.ErrorResponse;

@Getter
public class ForbiddenException extends RuntimeException {
    private final ErrorResponse errorResponse;

    public ForbiddenException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }
}
