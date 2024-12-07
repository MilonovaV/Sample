package com.aspect;
import java.util.List;

public class MainController {
    private MalwareData model;
    private MalwareAnalysis analysis;
    private Viewer viewer;

    public MainController(MalwareData model, MalwareAnalysis analysis, Viewer viewer) {
        this.model = model;
        this.analysis = analysis;
        this.viewer = viewer;
    }

    public void addSample(String sample) {
        model.addSample(sample);
    }

    public void displaySamples() {
        List<String> samples =  model.getSamples();
        this.viewer.displaySamples(samples);
    }

    public void filterSamples(String category) {
        List<String> samples =  model.filterSamples(category);;
        this.viewer.displaySamples(samples);
    }

    public void analyzeSample(String sample) {
        analysis.analyzeSample(sample);
    }
}

