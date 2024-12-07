package com.aspect;

import java.io.Console;
import java.security.NoSuchAlgorithmException;

import kotlin.internal.Exact;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // MalwareData model = new MalwareData();
        // MalwareAnalysis analysis = new MalwareAnalysis();
        // Viewer viewer = new Viewer();
        // MainController controller = new MainController(model, analysis, viewer);

        // SecurityAspect securityAspect = SecurityAspect.aspectOf();

        // // Attempt actions without authorization (should be blocked)
        // System.out.println("=== Unauthorized Attempts ===");
        // controller.addSample("SensitiveSample");
        // controller.filterSamples("Category1");
        // controller.displaySamples();
        // controller.analyzeSample("SensitiveSample");
        // System.out.println("\n");

        // // Authorize and retry actions
        // System.out.println("\n=== Authorized Actions ===");
        // securityAspect.authorize();

        // // Add and analyze samples
        // controller.addSample("SensitiveSample");
        // controller.displaySamples();
        // controller.filterSamples("Category1");
        // controller.analyzeSample("SensitiveSample");
        // System.out.println("\n");
        // throw new NullPointerException("Value cannot be null");


        Console cnsl = System.console();
        SecurityAspect securityAspect = SecurityAspect.aspectOf();

        String enteredPassword = cnsl.readLine( 
            "Enter password : ");

        boolean isPasswordValid = Authorization.verifyPassword(enteredPassword);
        if (isPasswordValid){
            securityAspect.authorize();
        }
    }
}
