package com.ai.framework;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class AIClient {

    public String askAI(String prompt) {

        try {

            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String requestBody = "{"
                    + "\"model\":\"llama3\","
                    + "\"prompt\":\"Respond ONLY in this format: ACTION:<action> VALUE:<value>. User request: "
                    + prompt + "\","
                    + "\"stream\":false"
                    + "}";

            OutputStream os = conn.getOutputStream();
            os.write(requestBody.getBytes());
            os.flush();
            os.close();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            br.close();

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}