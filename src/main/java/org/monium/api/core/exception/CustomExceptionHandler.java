package org.monium.api.core.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {Exception.class})
  protected ResponseEntity<Object> handleRuntimeExceptions(
      RuntimeException ex, WebRequest request) {
    Map<String, String> jsonAnswer = new HashMap<>();
    jsonAnswer.put("message", ex.getMessage());

    return handleExceptionInternal(
        ex, jsonAnswer, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }
}
