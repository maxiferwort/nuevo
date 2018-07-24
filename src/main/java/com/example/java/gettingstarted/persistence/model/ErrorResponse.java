package com.example.java.gettingstarted.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse implements Serializable {

  private String message;
  private Integer code;

  public String getMessage() {
    return message;
  }

  public ErrorResponse setMessage(String message) {
    this.message = message;
    return this;
  }

  public Integer getCode() {
    return code;
  }

  public ErrorResponse setCode(Integer code) {
    this.code = code;
    return this;
  }
}