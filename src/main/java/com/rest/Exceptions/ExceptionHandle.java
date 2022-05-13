package com.rest.Exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {
	@ExceptionHandler(Exception.class)
  public String Ex() {
	  return "Request Error";
  }
}
