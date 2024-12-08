package com.aspect;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class MainController {
    private MalwareData model;
    private MalwareAnalysis analysis;
    private Viewer viewer;

    public MainController(MalwareData model, MalwareAnalysis analysis, Viewer viewer) {
        this.model = model;
        this.analysis = analysis;
        this.viewer = viewer;
    }

    public void addSample(String filePath) throws Exception {
        String sample = Files.lines(Paths.get(filePath))
                                     .collect(Collectors.joining("\n"));
        String filename = Paths.get(filePath).getFileName().toString();
        model.addSample(sample, filename);
    }

    public void displaySamples() {
        List<Sample> samples =  model.getFullSamples();
        this.viewer.displaySamples(samples);
    }

    public void filterSamples(String category) {
        List<Sample> samples =  model.filterSamples(category);
        this.viewer.displaySamples(samples);
    }

    public void analyzeSample(String file) throws IOException, InterruptedException{
        Sample sample = model.getSample(file);
        analysis.analyzeSample(sample);
    }

    public void setCategory(String file, String category) {
        Sample sample = model.getSample(file);
        sample.setCategory(category);
    }
}

