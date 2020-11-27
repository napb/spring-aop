package com.demo.springaop.controller;

import com.demo.springaop.dto.Response;
import com.demo.springaop.service.Calculator;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OtherCalculatorController {

  private final Calculator calculator;

  //curl 'http://localhost:8080/pow/1/2'
  @GetMapping("/pow/{n1}/{n2}")
  public ResponseEntity<Response> pow(
      @PathVariable BigDecimal n1,
      @PathVariable BigDecimal n2)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Method powMethod = calculator.getClass().getDeclaredMethod("pow", BigDecimal.class, BigDecimal.class);
    powMethod.setAccessible(true);
    powMethod.invoke(calculator, n1, n2);

    return ResponseEntity
        .ok().build();
  }
}
