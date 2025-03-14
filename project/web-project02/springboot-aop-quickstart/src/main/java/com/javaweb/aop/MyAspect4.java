package com.javaweb.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(1)
@Component
//@Aspect
public class MyAspect4 {
    //before advice
    @Before("execution(* com.javaweb.service.impl.*.*(..))")
    public void before(){
        log.info("MyAspect4 -> before ...");
    }

    //after advice
    @After("execution(* com.javaweb.service.impl..*(..))")
    public void after(){
        log.info("MyAspect4 -> after ...");
    }
}
