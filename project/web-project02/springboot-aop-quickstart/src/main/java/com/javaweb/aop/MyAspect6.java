package com.javaweb.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Order(4)
@Aspect
@Component
public class MyAspect6 {

    @Pointcut("execution(* com.javaweb.service.*.*(..))")
    private void pt(){}


    //advice before -- Avant l'exécution de la méthode cible
//    @Before("execution(* com.javaweb.service.impl.*.*(..))")
    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        log.info("Before method invoked.");
        //1. obtenir object cible
        Object target = joinPoint.getTarget();
        log.info("Target :{}", target);
        //2. obtenir class cible
        String className = joinPoint.getTarget().getClass().getName();
        log.info("ClassName :{}", className);

        //3. obtenir method cible
        String methodName = joinPoint.getSignature().getName();
        log.info("MethodName :{}", methodName);

        //3. obtenir paramètre de method cible
        Object[] args = joinPoint.getArgs();
        log.info("Args :{}", Arrays.toString(args));
    }

    //exécute du code avant et après la méthode cible
    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Before : Around method invoked.");
        // Appelle et exécute la méthode originale de l'objet cible
        Object result = joinPoint.proceed();

        log.info("After : Around method invoked.");
        return result;
    }

    @After("pt()")
    public void after(){
        log.info("After method invoked.");

    }

    //exécuté uniquement si l'exécution se termine sans erreurs
    @AfterReturning("pt()")
    public void afterReturning(JoinPoint joinPoint){
        log.info("afterReturning ...");
    }

    //exécuté uniquement si une exception est levée lors de l'exécution
    @AfterThrowing("pt()")
    public void afterThrowing(JoinPoint joinPoint){
        log.info("afterThrowing ...");
    }

}






