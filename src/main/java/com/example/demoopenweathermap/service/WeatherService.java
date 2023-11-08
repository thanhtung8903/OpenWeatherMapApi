package com.example.demoopenweathermap.service;

import com.example.demoopenweathermap.entity.Weather;
import com.example.demoopenweathermap.entity.WeatherDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

public interface WeatherService {
    public WeatherDetail getWeatherByCity(String city);
}
