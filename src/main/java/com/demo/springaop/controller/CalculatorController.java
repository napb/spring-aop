package com.demo.springaop.controller;

import com.demo.springaop.dto.Response;
import com.demo.springaop.service.Calculator;
import com.demo.springaop.service.SimpleCalculatorService;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CalculatorController {

  private final SimpleCalculatorService simpleCalculatorService; //CGLib
  private final Calculator calculator; //JDK-Proxy

  //curl 'http://localhost:8080/addition/1/2'
  @GetMapping("/addition/{n1}/{n2}")
  public ResponseEntity<Response> addition(
      @PathVariable BigDecimal n1,
      @PathVariable BigDecimal n2) {

    return ResponseEntity
        .ok(simpleCalculatorService.add(n1, n2));
  }

  @GetMapping("/subtraction/{n1}/{n2}")
  public ResponseEntity<Response> subtraction(
      @PathVariable BigDecimal n1,
      @PathVariable BigDecimal n2) {

    return ResponseEntity
        .ok(simpleCalculatorService.subtraction(n1, n2));
  }

  //curl 'http://localhost:8080/multiplication/1/2'
  @GetMapping("/multiplication/{n1}/{n2}")
  public ResponseEntity<Response> multiplication(
      @PathVariable BigDecimal n1,
      @PathVariable BigDecimal n2) {

    return ResponseEntity
        .ok(calculator.multiplication(n1, n2));
  }

  @GetMapping("/division/{n1}/{n2}")
  public ResponseEntity<Response> division(
      @PathVariable BigDecimal n1,
      @PathVariable BigDecimal n2) {

    return ResponseEntity
        .ok(calculator.division(n1, n2));
  }

  //curl 'http://localhost:8080/exception'
  @GetMapping("/exception")
  public ResponseEntity<Void> throwsException() {
    simpleCalculatorService.throwsException();
    return ResponseEntity
        .status(503)
        .build();
  }
}
