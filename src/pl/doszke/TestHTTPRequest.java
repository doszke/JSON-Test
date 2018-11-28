package pl.doszke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestHTTPRequest {

    public static void main(String[] args) {

        StringBuffer response = new StringBuffer();
        String url = "http://api.openweathermap.org/data/2.5/weather?q=Wroclaw&units=metric&APPID=9e5c13de8f50c5a2215e9c5555002dbd";
        //na openweather trzeba zrobić konto i wejśc w API Keys, do godziny sie aktualizuje i    ^ wszystko od tego znaku dalej podmienić

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("Response: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(response);

    }

}
