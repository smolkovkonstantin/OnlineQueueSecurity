package org.online.queue.onlinequeuesecurity.model.dto;

import lombok.Builder;
import lombok.Value;
import org.online.queue.onlinequeuesecurity.model.entity.Credentials;

@Value
@Builder
public class CreateAccountDto {
    String firstName;
    String lastName;
    String username;
    Credentials credentials;
}
