package com.example.journalapp.service;

import com.example.journalapp.api.response.WeatherResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@NoArgsConstructor
public class WeatherService {

    private static final String apiKey = "270461c732691ceb463d748b22f610bf";

    private static final String api = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String finalApi = api.replace("CITY", city).replace("API_KEY", apiKey);
        ResponseEntity<WeatherResponse> reponse = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
        return reponse.getBody();
    }
}

