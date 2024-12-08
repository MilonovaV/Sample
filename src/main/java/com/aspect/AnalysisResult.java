package com.aspect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnalysisResult {
    private String id;
    private String sampleId;
    private String categorization;
    private String modelOutput;
    private Date timestamp;
    private int number_of_lines;

    public AnalysisResult(String id, String sampleId, String categorization, String modelOutput, int number_of_lines) {
        this.id = id;
        this.sampleId = sampleId;
        this.categorization = categorization;
        this.modelOutput = modelOutput;
        this.timestamp = new Date(); 
        this.number_of_lines = 0; 
    }

    public void generateReport() throws IOException {
        String reportContent = "Generating report for sample " + sampleId + "\n" +
                                "Model Output: " + modelOutput + "\n" +
                                "Categorization: " + categorization + "\n" +
                                "Timestamp: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp) + "\n";

        BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
        writer.write(reportContent);  
        writer.newLine();  
}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getCategorization() {
        return categorization;
    }

    public void setCategorization(String categorization) {
        this.categorization = categorization;
    }

    public String getModelOutput() {
        return modelOutput;
    }

    public void setModelOutput(String modelOutput) {
        this.modelOutput = modelOutput;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
