package com.example.demoopenweathermap.service;

import com.example.demoopenweathermap.entity.Weather;
import com.example.demoopenweathermap.entity.WeatherDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String API_KEY = "10b641e610c968a0a1bd27bd55d6047f";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&lang=vi&units=metric&appid={API_KEY}";

    @Override
    public WeatherDetail getWeatherByCity(String city) {
        RestTemplate restTemplate = new RestTemplate();
        WeatherDetail weatherDetail = restTemplate.getForObject(API_URL, WeatherDetail.class, city, API_KEY);

        Weather[] weather = weatherDetail.getWeather();
        String description = weather[0].getDescription();
        description = description.toUpperCase();
        weather[0].setDescription(description);
        weatherDetail.setWeather(weather);

        return weatherDetail;
    }

}

