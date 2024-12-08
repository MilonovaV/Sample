package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;
import java.util.logging.Level;

@Aspect
public class PerformanceMonitoringAspect {
    @Around("execution(* com.aspect.MalwareAnalysis.*(..))") 

    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;
        logger.log(Level.INFO,"Execution time of method " + joinPoint.getSignature().getName() + ": " + executionTime + " ms");

        return result;
    }
}