package dev.divyansh.weatherappjava.ExceptionHandlers;

import dev.divyansh.weatherappjava.Exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<String> handleNotFoundException(NotFoundException e){
        ResponseEntity<String> response=new ResponseEntity<>(e.getMessage(),org.springframework.http.HttpStatus.NOT_FOUND);
        return response;
    }
}
