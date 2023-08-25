package dev.shreya.springbootindepth.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException ex) {
    String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
    return ResponseEntity.badRequest().body(errorMessage);
  }

}
