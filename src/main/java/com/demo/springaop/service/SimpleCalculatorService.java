package com.demo.springaop.service;

import com.demo.springaop.dto.Response;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalculatorService {

  public Response add(BigDecimal n1, BigDecimal n2) {
    return new Response(n1.add(n2));
  }

  public Response subtraction(BigDecimal n1, BigDecimal n2) {
    return new Response(n1.subtract(n2));
  }

  public void throwsException() {
    throw new RuntimeException("Exception!!!");
  }

}
