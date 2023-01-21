package com.project.backend.exceptions;

import com.project.backend.dtos.exceptions.StandardErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardErrorDTO> objectNotFound(ObjectNotFoundException e) {
        StandardErrorDTO err = new StandardErrorDTO(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardErrorDTO> dataIntegrityException(DataIntegrityException e) {
        StandardErrorDTO err = new StandardErrorDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(InvalidTransferException.class)
    public ResponseEntity<StandardErrorDTO> invalidTransferException(InvalidTransferException e) {
        StandardErrorDTO err = new StandardErrorDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
