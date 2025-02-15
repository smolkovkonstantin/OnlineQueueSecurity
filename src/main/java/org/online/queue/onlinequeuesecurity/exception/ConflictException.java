package org.online.queue.onlinequeuesecurity.exception;

import lombok.Getter;
import org.online.queue.onlinequeuesecurity.model.response.ErrorResponse;

@Getter
public class ConflictException extends RuntimeException {
    private final ErrorResponse errorResponse;

    public ConflictException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }
}
