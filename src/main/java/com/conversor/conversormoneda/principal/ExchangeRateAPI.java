package com.conversor.conversormoneda.principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ExchangeRateAPI {

    private static final String API_KEY = "6c258bb3fe99e09a61d97b59"; // mi key exchange rate
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public static double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            URL url = new URL(API_URL + API_KEY + "/pair/" + fromCurrency + "/" + toCurrency);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            StringBuilder response = new StringBuilder();

            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            conn.disconnect();

            JSONObject jsonObj = new JSONObject(response.toString());
            return jsonObj.getDouble("conversion_rate");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0.0;
    }
}
