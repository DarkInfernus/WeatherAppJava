package dev.divyansh.weatherappjava.Controllers;

import dev.divyansh.weatherappjava.Exceptions.NotFoundException;
import dev.divyansh.weatherappjava.Services.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{location}")
    public String getWeather(@PathVariable("location") String location) throws NotFoundException {
        return weatherService.getWeather(location);
    }
}
