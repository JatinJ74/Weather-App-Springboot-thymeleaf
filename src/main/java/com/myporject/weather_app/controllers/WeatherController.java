package com.myporject.weather_app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.myporject.weather_app.model.WeatherResponse;

@Controller
public class WeatherController {

    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appId=" + apiKey + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse;
        try {
            weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
            if (weatherResponse != null) {
                model.addAttribute("city", weatherResponse.getName());
                model.addAttribute("country", weatherResponse.getSys().getCountry());
                model.addAttribute("description", weatherResponse.getWeather().get(0).getDescription());
                model.addAttribute("temperature", weatherResponse.getMain().getTemp());
                model.addAttribute("humidity", weatherResponse.getMain().getHumidity());
                model.addAttribute("windSpeed", weatherResponse.getWind().getSpeed());

                String weatherIcon = "wi wi-owm-" + weatherResponse.getWeather().get(0).getId();
                model.addAttribute("weatherIcon", weatherIcon);
            } else {
                throw new CityNotFoundException("City not found.");
            }
        } catch (HttpClientErrorException e) {
            throw new CityNotFoundException("City not found.");
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred.");
        }
        return "weather";
    }

    @ExceptionHandler(CityNotFoundException.class)
    public String handleCityNotFound(CityNotFoundException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "weather";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("error", "An unexpected error occurred.");
        return "weather";
    }

    // Custom Exception class
    @SuppressWarnings("serial")
    public static class CityNotFoundException extends RuntimeException {
        public CityNotFoundException(String message) {
            super(message);
        }
    }
}
