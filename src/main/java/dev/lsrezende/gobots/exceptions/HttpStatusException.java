package dev.lsrezende.gobots.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;

public class HttpStatusException extends RuntimeException {
    private String message;
    private final HttpStatus httpStatus;
    private List<String> messages;

    public HttpStatusException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return this.message;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public List<String> getMessages() {
        return this.messages;
    }
}
