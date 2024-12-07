package com.aspect;
import org.aspectj.lang.JoinPoint;

public aspect LoggingAspect {
    pointcut loggableMethods() : 
        execution(* MalwareAnalysis.*(..)) || 
        execution(* MainController.*(..));

    before() : loggableMethods() {
        System.out.println("LoggingAspect: Method called - " 
            + thisJoinPoint.getSignature().getName()
            + " with arguments: " + java.util.Arrays.toString(thisJoinPoint.getArgs()));
    }

    after() : loggableMethods() {
        System.out.println("LoggingAspect: Method completed - " 
            + thisJoinPoint.getSignature().getName());
    }
}
