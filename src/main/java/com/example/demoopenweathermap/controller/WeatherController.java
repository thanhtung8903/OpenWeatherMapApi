package com.example.demoopenweathermap.controller;

import com.example.demoopenweathermap.entity.WeatherDetail;
import com.example.demoopenweathermap.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String index() {
        return "weather";
    }

    @GetMapping("/{city}")
    public String test(@PathVariable String city, Model theModel) {
        WeatherDetail weatherDetail = weatherService.getWeatherByCity(city);
        theModel.addAttribute("weatherDetail", weatherDetail);
        return "weather";
    }

}

