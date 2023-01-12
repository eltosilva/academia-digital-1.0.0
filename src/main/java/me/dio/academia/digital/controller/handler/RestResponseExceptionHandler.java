package me.dio.academia.digital.controller.handler;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler{
  
  @ExceptionHandler(value = {EmptyResultDataAccessException.class, EntityNotFoundException.class})
  public ResponseEntity<Object> handlerNoSuchElement(Exception ex, WebRequest wr){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }
}
