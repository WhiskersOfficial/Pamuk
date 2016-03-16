package org.whiskersofficial.pamuk.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPUtils {

    public static String GETRequest(String urlString) {
        StringBuilder result = new StringBuilder();
        URL url = null;
        BufferedReader rd = null;
        HttpURLConnection conn = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            if (url != null) {
                conn = (HttpURLConnection) url.openConnection();
            }
            if (conn != null) {
                conn.setRequestMethod("GET");
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
