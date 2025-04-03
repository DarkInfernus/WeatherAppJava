package dev.divyansh.weatherappjava.Client;

import dev.divyansh.weatherappjava.Exceptions.NotFoundException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class WeatherStack {
    private RestTemplate restTemplate;
    @Value("${weatherstack.api.key}")
    private String apiKey;
    public WeatherStack(){
        this.restTemplate = new RestTemplate();

    }
    public String getWeather(String location) throws NotFoundException{
        ResponseEntity<String> response= restTemplate.getForEntity("http://api.weatherstack.com/current?access_key="+apiKey+"&query="+location+"&units=m",String.class);
        JSONObject obj=new JSONObject(response.getBody());
        if (obj.has("success")) {
            throw new NotFoundException("Location not found");
        }
        JSONObject current = obj.getJSONObject("current");
        String weatherDescription = current.getJSONArray("weather_descriptions").getString(0);
        double temperature = current.getDouble("temperature");
        double feelsLike = current.getDouble("feelslike");
        return "It is "+weatherDescription+" with a temperature of "+temperature+" degree Celsius and it feels like "+feelsLike+" degree Celsius";
    }
}
