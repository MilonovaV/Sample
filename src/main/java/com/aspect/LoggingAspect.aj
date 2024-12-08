package com.aspect;
import org.aspectj.lang.JoinPoint;
import java.util.logging.Logger;
import java.util.logging.Level;

public aspect LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    pointcut loggableMethods() : 
        execution(* MalwareAnalysis.*(..)) || 
        execution(* MainController.*(..));

    before() : loggableMethods() {
        logger.log(Level.INFO,"LoggingAspect: Method called - " 
            + thisJoinPoint.getSignature().getName()
            + " with arguments: " + java.util.Arrays.toString(thisJoinPoint.getArgs()));
    }

    after() : loggableMethods() {
        logger.log(Level.INFO,"LoggingAspect: Method completed - " 
            + thisJoinPoint.getSignature().getName());
    }
}
