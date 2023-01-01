package com.example.blog.error;

import com.example.blog.controller.Post.PostController;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

@Data
public class ResponseError {

  private int status;
  private String message;

  public ResponseError(HttpStatus status, String message) {
    Logger logger = LoggerFactory.getLogger(PostController.class);

    setStatus(status.value());
    setMessage(message);

    if (status.is4xxClientError()) {
      logger.warn(status.getReasonPhrase());
    }

    if (status.is5xxServerError()) {
      logger.error(status.getReasonPhrase());
    }
  }
}
