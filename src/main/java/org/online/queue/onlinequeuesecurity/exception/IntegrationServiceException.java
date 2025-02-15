package org.online.queue.onlinequeuesecurity.exception;

import lombok.Getter;
import org.online.queue.onlinequeuesecurity.model.response.ErrorResponse;

@Getter
public class IntegrationServiceException extends RuntimeException {

    private final ErrorResponse errorResponse;

    public IntegrationServiceException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }

}
