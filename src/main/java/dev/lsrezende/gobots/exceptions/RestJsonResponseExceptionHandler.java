package dev.lsrezende.gobots.exceptions;

import dev.lsrezende.gobots.dto.JsonResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestJsonResponseExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger LOG = LoggerFactory.getLogger(RestJsonResponseExceptionHandler.class);

    @ExceptionHandler({HttpStatusException.class})
    protected ResponseEntity<JsonResponseDTO> handleConflict(HttpStatusException ex) {
        return new ResponseEntity<>(JsonResponseDTO.otherReponse(ex.getMessage(), ex.getMessages()), ex.getHttpStatus());
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<JsonResponseDTO> handleConflict(Exception ex) {
        this.LOG.error("Exception Handler: ".concat(ex.getMessage()), ex);
        return new ResponseEntity<>(JsonResponseDTO.otherReponse("Internal Server Error!"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
