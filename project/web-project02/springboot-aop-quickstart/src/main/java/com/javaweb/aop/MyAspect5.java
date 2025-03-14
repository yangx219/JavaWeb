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
public class MyAspect5 {
    //before advice
//    complete----- @Before("execution(public void com.javaweb.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
//    don't recommend- @Before("execution(void delete(java.lang.Integer))")
//    return arbitreire @Before("execution(* com.javaweb.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
//    @Before("execution(* com.javaweb.service.impl.*.*(java.lang.Integer))")
//    @Before("execution(* com.javaweb.service.impl.*.*(*))")
//    @Before("execution(* com.javaweb.service.impl.*.del*(*))")
//    @Before("execution(* com..service.impl.*.*(..))")
    //list and delete
//    @Before("execution(* com.javaweb.service.impl.DeptServiceImpl.delete(java.lang.Integer))||"+"execution(* com.javaweb.service.impl.DeptServiceImpl.list(..))")
    @Before("@annotation(com.javaweb.anno.LogOperation)")
    public void before(){
        log.info("MyAspect5 -> before ...");
    }

   /* //after advice
    @After("execution(* com.javaweb.service.impl..*(..))")
    public void after(){
        log.info("MyAspect4 -> after ...");
    }*/
}
