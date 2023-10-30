package com.example.demoopenweathermap.controller;

import com.example.demoopenweathermap.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String getWeatherPage(Model model) {
        return "index";
    }

    @GetMapping("/weather/{city}")
    @ResponseBody
    public ResponseEntity<String> getWeather(@PathVariable String city) {
        ResponseEntity<String> weatherResponse = weatherService.getWeatherByCity(city);
        String weather = weatherResponse.getBody();
        return weatherResponse;
    }
}

