package com.example.blog.exception.Post;

import com.example.blog.error.ResponseError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class PostExceptionHandler extends ResponseEntityExceptionHandler {
  Logger logger = LoggerFactory.getLogger(Controller.class);

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(
      Exception ex,
      @Nullable Object body,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    ResponseError re = new ResponseError(status, ex.getMessage());

    return super.handleExceptionInternal(ex, re, headers, status, request);
  }
}
