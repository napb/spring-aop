package com.demo.springaop.service;

import com.demo.springaop.dto.Response;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class AdvancedCalculatorService implements Calculator {

  @Override
  public Response multiplication(BigDecimal n1, BigDecimal n2) {
    return new Response(n1.multiply(n2));
  }

  @Override
  public Response division(BigDecimal n1, BigDecimal n2) {
    return new Response(n1.divide(n2));
  }

  public Response pow(BigDecimal n1, BigDecimal n2) {
    return new Response(n1.pow(n2.intValue()));
  }

}
