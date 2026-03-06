package com.ai.framework;
import java.util.Scanner;

public class MainAgent {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AIClient aiClient = new AIClient();
        ActionExecutor executor = new ActionExecutor();

        while (true) {

            System.out.println("\nEnter your request (type STOP to exit):");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("STOP")) {
                System.out.println("Agent stopped.");
                break;
            }

            System.out.println("Generating...");

            String aiResponse = aiClient.askAI(userInput);

            System.out.println("AI Response:\n" + aiResponse);

            executor.execute(aiResponse);
        }
    }
}