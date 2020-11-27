package com.demo.springaop.service;

import com.demo.springaop.dto.Response;
import java.math.BigDecimal;

public interface Calculator {

  Response multiplication(BigDecimal n1, BigDecimal n2);

  Response division(BigDecimal n1, BigDecimal n2);

}
