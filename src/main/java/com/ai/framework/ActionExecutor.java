package com.ai.framework;

import java.awt.Desktop;
import java.net.URI;

public class ActionExecutor {

    public void execute(String response) {

        try {

            if (response.contains("youtube")) {

                System.out.println("Opening YouTube...");
                Desktop.getDesktop().browse(new URI("https://www.youtube.com"));

            } else if (response.contains("google")) {

                System.out.println("Opening Google...");
                Desktop.getDesktop().browse(new URI("https://www.google.com"));

            } else {

                System.out.println("No valid action found.");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}