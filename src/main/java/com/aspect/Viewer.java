package com.aspect;
import java.util.List;

public class Viewer {
    public void displaySamples(List<String> samples) {
        System.out.println("Displaying malware samples:");
        for (String sample : samples) {
            System.out.println("- " + sample);
        }
    }

    public void showFilteredSamples(List<String> filteredSamples, String category) {
        System.out.println("Displaying filtered samples by " + category + ":");
        for (String sample : filteredSamples) {
            System.out.println("- " + sample);
        }
    }
}