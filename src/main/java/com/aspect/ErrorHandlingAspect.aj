package com.aspect;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import java.util.logging.Level;

public aspect ErrorHandlingAspect {

    pointcut errorHandling() : execution(* *(..));

    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    Object around() : errorHandling() {
        try {
            Object result = proceed();
            return result;
        } catch (Exception e) {
            logger.log(Level.WARNING,"Error detected in " + thisJoinPoint.getSignature().getName() + " function - " 
            + e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }
}
