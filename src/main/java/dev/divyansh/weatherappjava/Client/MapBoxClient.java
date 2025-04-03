package dev.divyansh.weatherappjava.Client;

import dev.divyansh.weatherappjava.Exceptions.NotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class MapBoxClient {
    private RestTemplate restTemplate= new RestTemplate();
    @Value("${mapbox.access_token}")
    private String access_token;
    public List<String> getLocation(String location) throws NotFoundException{
        ResponseEntity<String> response=restTemplate.getForEntity("https://api.mapbox.com/search/geocode/v6/forward?q="+location+"&access_token="+access_token+"&limit=10", String.class);
        JSONObject ob = new JSONObject(response.getBody());
        JSONArray features = ob.getJSONArray("features");
        if(features.length()==0){
            throw new NotFoundException("Location not found");
        }
        List<String> cities = new ArrayList<>();
        for(int i=0;i<features.length();i++){
            JSONObject properties = features.getJSONObject(i).getJSONObject("properties");
            String preferredName = properties.getString("full_address");
            cities.add(preferredName);
        }
        return cities;
    }
}
