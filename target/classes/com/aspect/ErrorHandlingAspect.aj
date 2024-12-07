package com.aspect;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public aspect ErrorHandlingAspect {

    pointcut errorHandling() : execution(* *(..));

    Object around() : errorHandling() {
        try {
            Object result = proceed();
            return result;
        } catch (Exception e) {
            System.out.println("Error detected in " + thisJoinPoint.getSignature().getName() + " function - " 
            + e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }
}
