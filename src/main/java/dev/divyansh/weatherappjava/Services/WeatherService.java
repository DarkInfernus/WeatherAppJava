package dev.divyansh.weatherappjava.Services;

import dev.divyansh.weatherappjava.Client.WeatherStack;
import dev.divyansh.weatherappjava.Exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private WeatherStack weatherStack;
    public WeatherService(WeatherStack weatherStack){
        this.weatherStack=weatherStack;
    }
    public String getWeather(String location) throws NotFoundException {
        return weatherStack.getWeather(location);
    }
}
