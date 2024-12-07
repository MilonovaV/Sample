package com.aspect;
import java.util.List;

public class Viewer {
    public void displaySamples(List<Sample> samples) {
        System.out.println("Displaying all malware samples:");
        for (Sample sample : samples) {
            System.out.println(sample.getFilename());
        }
    }

    public void showFilteredSamples(List<String> filteredSamples, String category) {
        System.out.println("Displaying filtered samples by " + category + ":");
        for (String sample : filteredSamples) {
            System.out.println("- " + sample);
        }
    }
}