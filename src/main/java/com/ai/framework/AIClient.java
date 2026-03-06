package com.ai.framework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AIClient {

    public String getAIResponse(String prompt) {

        String response = "";

        try {

            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Request JSON
            String jsonInput = "{"
                    + "\"model\":\"phi3\","
                    + "\"prompt\":\"" + prompt + "\","
                    + "\"stream\":false"
                    + "}";

            OutputStream os = conn.getOutputStream();
            os.write(jsonInput.getBytes());
            os.flush();
            os.close();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            String line;
            StringBuilder result = new StringBuilder();

            while ((line = br.readLine()) != null) {
                result.append(line);
            }

            br.close();

            // Extract only the AI response
            String fullJson = result.toString();

            int start = fullJson.indexOf("\"response\":\"") + 12;
            int end = fullJson.indexOf("\",\"done\"");

            response = fullJson.substring(start, end);

            // Format the response properly
            response = response.replace("\\n", "\n")
                               .replace("\\\"", "\"");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}