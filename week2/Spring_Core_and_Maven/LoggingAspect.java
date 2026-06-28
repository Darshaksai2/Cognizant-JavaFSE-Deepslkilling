package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

// Exercise 3 & 8: Implementing Basic and Advanced AOP Logging Aspect
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.BookService.*(..))")
    public void logBefore() {
        System.out.println("[AOP PRE-LOG] Method execution target initialized.");
    }

    @After("execution(* com.library.service.BookService.*(..))")
    public void logAfter() {
        System.out.println("[AOP POST-LOG] Method execution target finalized.");
    }

    @Around("execution(* com.library.service.BookService.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("[AOP PERFORMANCE] " + joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
}
/*
OUTPUT:
(This aspect automatically intercepts BookService methods during runtime via Spring AOP.)
*/