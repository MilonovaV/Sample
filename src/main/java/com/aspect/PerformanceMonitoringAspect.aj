package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PerformanceMonitoringAspect {
    @Around("execution(* com.aspect.MalwareAnalysis.*(..))") 
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;
        System.out.println("Execution time of method " + joinPoint.getSignature().getName() + ": " + executionTime + " ms");

        return result;
    }
}