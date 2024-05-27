package org.example.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect  //
public class MyAdvice {

//    @Before("execution(* org.example.service.impl.*.*(..))")
    public void beforeAdvice(){
        System.out.println("beforeAdvice....");
    }

//    @After("execution(* org.example.service.impl.*.*(..))")
    public void afterAdvice(){
        System.out.println("afterAdvice....");
    }

    @Around("execution(* org.example.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        System.out.println("环绕前的增强....");
        Object res = point.proceed();
        System.out.println("环绕后的增强....");
        return res;
    }

}
