package com.aspect;

import java.io.Console;
import java.util.Scanner;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, Exception {

        // Initialize the required classes
        SecurityAspect securityAspect = SecurityAspect.aspectOf();
        Authorization.login(securityAspect);

        MalwareData model = new MalwareData();
        MalwareAnalysis analysis = new MalwareAnalysis();
        Viewer viewer = new Viewer();
        MainController controller = new MainController(model, analysis, viewer);

        // Display the menu and handle user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display options to the user
            System.out.println("Choose an option:");
            System.out.println("1. Add Sample");
            System.out.println("2. Filter Samples");
            System.out.println("3. Display Samples");
            System.out.println("4. Analyze Sample");
            System.out.println("5. Exit");

            // Get user choice
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left by nextInt()

            switch (choice) {
                case 1:
                    // Add Sample
                    System.out.print("Enter the file path of the sample to add: ");
                    String filePath = scanner.nextLine();
                    controller.addSample(filePath);
                    break;

                case 2:
                    // Filter Samples
                    System.out.print("Enter the category to filter by: ");
                    String category = scanner.nextLine();
                    controller.filterSamples(category);
                    break;

                case 3:
                    // Display Samples
                    controller.displaySamples();
                    break;

                case 4:
                    // Analyze Sample
                    System.out.print("Enter the sample filename to analyze: ");
                    String sampleFilename = scanner.nextLine();
                    controller.analyzeSample(sampleFilename);
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    // Invalid input
                    System.out.println("Invalid option, please try again.");
                    break;
            }

            // Add a line break for better readability between operations
            System.out.println("\n");
        }
    }
}
