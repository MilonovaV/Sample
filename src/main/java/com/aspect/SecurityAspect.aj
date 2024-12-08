package com.aspect;

import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import java.util.logging.Logger;
import java.util.logging.Level;

public aspect SecurityAspect {
    private boolean isAuthorized = false; 
    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    pointcut securedCall() : 
        call(* MainController.addSample(..)) || 
        call(* MainController.displaySamples(..)) || 
        call(* MainController.filterSamples(..)) || 
        call(* MainController.analyzeSample(..));

    Object around() : securedCall() {
        if (!isAuthorized) {
            MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
            Class<?> returnType = methodSignature.getReturnType();
            String methodName = methodSignature.getName();

            logger.log(Level.WARNING,"SecurityAspect: Unauthorized access detected! Blocking access for: " + methodName);
            
            if (returnType.equals(void.class)) {
                return null;  
            } else if (returnType.isAssignableFrom(List.class)) {
                return new ArrayList<>();  
            }
        } else {
            return proceed();
        }
        return null;  
    }

    public void authorize() {
        isAuthorized = true;
    }

    public void revokeAuthorization() {
        isAuthorized = false;
    }
}

