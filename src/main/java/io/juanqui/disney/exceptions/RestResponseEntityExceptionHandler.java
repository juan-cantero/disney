package io.juanqui.disney.exceptions;

import io.juanqui.disney.exceptions.models.ExceptionBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

// controller advice es un interceptor que agarra todas las exepciones que le indiquemos, de esa
// forma podemos manipular las excepciones globales a nuestro gusto
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> HandleResourceNotFoundException(ResourceNotFoundException ex) {

        ExceptionBody body = new ExceptionBody(ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
