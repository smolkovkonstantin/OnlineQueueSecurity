package org.online.queue.onlinequeuesecurity.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LogMessage {
    SIGN_UP("user signed up"),
    SIGN_IN("user signed in: %s"),
    UPDATE_TOKEN("");

    private final String value;

    public String create(Object... details) {
        var message = String.format(this.value, details);

        return message;
    }
}
