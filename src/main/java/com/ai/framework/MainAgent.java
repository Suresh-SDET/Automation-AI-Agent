package com.ai.framework;

import java.util.Scanner;

public class MainAgent {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AIClient aiClient = new AIClient();
        ActionExecutor executor = new ActionExecutor();

        System.out.println("🤖 Automation AI Agent Started");
        System.out.println("Type your prompt (type 'exit' to stop)");

        while (true) {

            System.out.print("\nYou: ");
            String prompt = scanner.nextLine();

            if (prompt.equalsIgnoreCase("exit")) {
                break;
            }

            // Get AI Response
            String response = aiClient.getAIResponse(prompt);

            System.out.println("\n==============================");
            System.out.println("🤖 AI Response");
            System.out.println("==============================\n");

            System.out.println(response);

            // Execute actions like open youtube/google
            executor.execute(response);
        }

        scanner.close();
    }
}