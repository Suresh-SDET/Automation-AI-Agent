package com.ai.framework;

import java.awt.Desktop;
import java.net.URI;

public class ActionExecutor {

    public void execute(String aiResponse) {

        try {

            System.out.println("\nAI Response:");
            System.out.println(aiResponse);

            if (aiResponse.toLowerCase().contains("youtube")) {

                System.out.println("Opening YouTube...");
                Desktop.getDesktop().browse(new URI("https://www.youtube.com"));

            }

            else if (aiResponse.toLowerCase().contains("google")) {

                System.out.println("Opening Google...");
                Desktop.getDesktop().browse(new URI("https://www.google.com"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}