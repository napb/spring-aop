package com.demo.springaop.aspect;

import com.demo.springaop.dto.Response;
import java.time.LocalDateTime;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
@Slf4j
public class AspectConfig {
  /*
  @After(
      "within(@org.springframework.stereotype.Service *)"
  )
  public void afterAdvice(JoinPoint joinPoint) {
    log.info("----- afterAdvice -----");
    log.info("Method: " + joinPoint.getSignature().getName());
    log.info("Thread: " + Thread.currentThread().getName());
    log.info("Return: [" + joinPoint.getThis() + "]");
    log.info("----- afterAdvice -----");
    log.info("");
  }
  */
  /*
  @AfterReturning(
      pointcut = "within(@org.springframework.stereotype.Service *)",
      returning = "returnedValue"
  )
  public void afterReturningAdvice(JoinPoint joinPoint, Object returnedValue) {
    log.info("----- afterReturningAdvice -----");
    log.info("Method: " + joinPoint.getSignature().getName());
    log.info("Thread: " + Thread.currentThread().getName());
    log.info("Return: [" + returnedValue + "]");
    log.info("----- afterReturningAdvice -----");
    log.info("");
  }
  */
  /*
  @AfterThrowing(
      pointcut = "execution(public void throwsException())",
      throwing = "ex"
  )
  public void afterThrowingAdvice(JoinPoint joinPoint, Throwable ex) {
    log.info("----- afterThrowingAdvice -----");
    log.info("Method: " + joinPoint.getSignature().getName());
    log.info("Thread: " + Thread.currentThread().getName());
    log.info("Exception: [" + ex.getMessage() + "]");
    log.info("----- afterThrowingAdvice -----");
    log.info("");
  }
  */
  /*
  @Before("execution(public void throwsException())")
  public void beforeAdvice(JoinPoint joinPoint) {
    log.info("----- beforeAdvice -----");
    log.info("Method: " + joinPoint.getSignature().getName());
    log.info("Thread: " + Thread.currentThread().getName());
    log.info("----- beforeAdvice -----");
    log.info("");
  }
  */

  @Around(
      "within(@org.springframework.stereotype.Service *)"
  )
  public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

    StopWatch stopWatch = new StopWatch(
        "[aroundAdvice] Monitor " + proceedingJoinPoint.getSignature().getName());
    stopWatch.start("initializing");
    log.info("Arguments: " + Arrays.toString(proceedingJoinPoint.getArgs()));
    stopWatch.stop();

    stopWatch.start("processing");
    Response proceed = (Response) proceedingJoinPoint.proceed();
    stopWatch.stop();

    stopWatch.start("finalizing");
    stopWatch.stop();

    log.info("Thread: " + Thread.currentThread().getName());
    log.info("Return: [" + proceed + "]");
    log.info("");
    log.info("----- StopWatch Info -----");
    log.info(stopWatch.prettyPrint());
    log.info("----- aroundAdvice -----");

    return proceed;
  }
}
