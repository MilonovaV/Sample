package com.aspect;

import java.util.Date;

public class Sample {
    private String filename;
    private String sampleData;
    private Date uploadDate;

    private Boolean preprocessed;
    private String analysisResult;

    // Constructor
    public Sample(String filename, String sampleData) {
        this.filename = filename;
        this.sampleData = sampleData;
        this.uploadDate = new Date();
    }

    public void setPreprocessed(Boolean preprocessed) {
        this.preprocessed = preprocessed;
    }

    public void setAnalysisResult(String analysisResult) {
        this.analysisResult = analysisResult;
    }

    // Getters
    public String getFilename() {
        return filename;
    }

    public String getSampleData() {
        return sampleData;
    }

    // Optionally, override toString() for easy display
    @Override
    public String toString() {
        return "Sample{filename='" + filename + "', sampleData='" + sampleData + "'}";
    }
    
}
