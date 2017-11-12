package com.example.sophie.remumber;

import android.app.Activity;
import android.location.Location;
import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sophie on 12/11/2017.
 */

public class Weather {

    public static void getWeather(Location location) {
        //String locString = HomeActivity.mLocationField.getText().toString();

        String locString = "York";


        // HTTP request to get weather from latitude and longitude
        HttpURLConnection connection = null;
        //String urlParameters = locString;
        String targetURL = "http://api.openweathermap.org/data/2.5/weather?q=" + locString;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            /*connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");*/

            /*connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));*/
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            /*DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();*/

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            String responseString = response.toString();
            WeatherResponse weatherInfo = new ObjectMapper().readValue(responseString, WeatherResponse.class);
            HomeActivity.weatherResponse =  weatherInfo;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static class WeatherResponse {
        public String weather;
        public String main;
        public String description;
        public String temp;
        public Object coord;
    }
}
