package dev.edgeahz.userapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

public class JwtAttemptAuthenticationException extends AuthenticationException {

    private HttpStatus status;

    public JwtAttemptAuthenticationException(String msg) {
        super(msg);
    }

    public JwtAttemptAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JwtAttemptAuthenticationException(String msg, Throwable cause, HttpStatus status) {
        super(msg, cause);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
