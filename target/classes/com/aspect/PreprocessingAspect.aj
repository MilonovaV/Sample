package com.aspect;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public aspect PreprocessingAspect {

    // Anonymize sample before uploading
    pointcut uploadSampleCall(String sample) : execution(* MalwareData.uploadSample(..)) && args(sample);

    void around(String sample) : uploadSampleCall(sample) {
        System.out.println("PreprocessingAspect: Anonymizing sample before upload.");
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] anonymized = md.digest(sample.getBytes());
        String result = new String(anonymized, StandardCharsets.UTF_8);
        proceed(result);  
    }

    // Preprocess sample before analysis
    pointcut analyzeSampleCall(String sample) : execution(* MalwareAnalysis.analyzeSample(..)) && args(sample);

    void around(String sample) : analyzeSampleCall(sample) {
        System.out.println("PreprocessingAspect: Preprocessing sample before analysis.");
        String preprocessedSample = sample.trim().toLowerCase();
        proceed(preprocessedSample);  
    }
}
