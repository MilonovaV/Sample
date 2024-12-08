package com.aspect;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public aspect PreprocessingAspect {

    // Anonymize sample before uploading
    pointcut uploadSampleCall(String sample) : execution(* MalwareData.uploadSample(..)) && args(sample);

    void around(String sample) : uploadSampleCall(sample) {
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
    pointcut analyzeSampleCall(Sample sample) : execution(* MalwareAnalysis.analyzeSample(..)) && args(sample);

    void around(Sample sample) : analyzeSampleCall(sample) {
        if (!sample.isPreprocessed()) {
            String preprocessedSample = sample.getSampleData().trim().toLowerCase();
            sample.setPreprocessedSample(preprocessedSample);
            sample.setPreprocessed(true);   
        }

        proceed(sample);  
    }
}
