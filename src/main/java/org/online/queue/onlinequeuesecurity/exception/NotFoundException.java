package org.online.queue.onlinequeuesecurity.exception;

import lombok.Getter;
import org.online.queue.onlinequeuesecurity.model.response.ErrorResponse;

@Getter
public class NotFoundException extends RuntimeException {


    private final ErrorResponse errorResponse;

    public NotFoundException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }
}
