package com.aspect;

import java.util.Date;

public class Sample {
    private String filename;
    private String sampleData;
    private String preprocessedSample;
    private Date uploadDate;

    private Boolean preprocessed;
    private String analysisResult;

    private String category;

    // Constructor
    public Sample(String filename, String sampleData) {
        this.filename = filename;
        this.sampleData = sampleData;
        this.uploadDate = new Date();
        this.preprocessed = false;
    }

    public void setPreprocessed(Boolean preprocessed) {
        this.preprocessed = preprocessed;
    }

    public void setAnalysisResult(String analysisResult) {
        this.analysisResult = analysisResult;
    }

    public void setPreprocessedSample(String preprocessedSample) {
        this.preprocessedSample = preprocessedSample;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Getters
    public String getFilename() {
        return filename;
    }

    public String getSampleData() {
        return sampleData;
    }

    public String getCategory() {
        return category;
    }

    // Optionally, override toString() for easy display
    @Override
    public String toString() {
        return "Sample{filename='" + filename + "', sampleData='" + sampleData + "'}";
    }

    public Boolean isPreprocessed() {
        return preprocessed;
    }
    
}
