package com.javaweb.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j//log
@Aspect//Indique que cette classe est une classe AOP
@Component
public class RecordTimeAspect {

    @Around("execution(* com.javaweb.service.impl.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //1.start time
        long startTime = System.currentTimeMillis();
        //2. Exécuter la méthode originale
        Object result = joinPoint.proceed();

        //3. end time
        long endTime = System.currentTimeMillis();

        log.info("Durée d'exécution de la méthode {} : {}ms",joinPoint.getSignature(), endTime - startTime);

        return result;
    }
}
