package br.com.lavajato.controller.exceptionerror;

import br.com.lavajato.services.exceptionerror.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandarError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        StandarError erro = new StandarError();
        erro.setTimestemp(Instant.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setMessage("Resource not found");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

    }
}
