package br.com.challenge.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundAnyDataException extends RuntimeException {

    public NotFoundAnyDataException(String message) {
        super(message);
    }
}
