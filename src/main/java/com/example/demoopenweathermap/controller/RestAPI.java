package com.example.demoopenweathermap.controller;

import com.example.demoopenweathermap.entity.WeatherDetail;
import com.example.demoopenweathermap.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestAPI {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public WeatherDetail getWeatherByCity(@PathVariable String city) {
        return weatherService.getWeatherByCity(city);
    }
}
