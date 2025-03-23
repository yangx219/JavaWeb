package com.javaweb.aop;

import com.javaweb.anno.Log;
import com.javaweb.mapper.OperateLogMapper;
import com.javaweb.pojo.OperateLog;
import com.javaweb.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    // Around advice
    @Around("@annotation(com.javaweb.anno.Log)")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        // method of operation
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long costTime = endTime - startTime;

        // crate OperateLog
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getCurrentUserId()); // 需要实现 getCurrentUserId 方法
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(result.toString());
        operateLog.setCostTime(costTime);

        log.info("Save OperationLog : {} ", operateLog);

        // insert(operateLog)
        operateLogMapper.insert(operateLog);
        return result;
    }


    // exemple : getCurrentUserId
    private int getCurrentUserId() {
        Integer id = CurrentHolder.getCurrentId();
        if (id == null) {
            log.warn("⚠️ CurrentHolder 中没有获取到当前用户ID！");
            return 0; // 或者你可以选择不记录日志，return 0 等
        }
        return id;
    }
}