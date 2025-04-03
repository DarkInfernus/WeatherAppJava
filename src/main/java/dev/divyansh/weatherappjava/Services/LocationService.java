package dev.divyansh.weatherappjava.Services;

import dev.divyansh.weatherappjava.Client.MapBoxClient;
import dev.divyansh.weatherappjava.Exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private MapBoxClient mapBoxClient;
    public LocationService(MapBoxClient mapBoxClient){
        this.mapBoxClient=mapBoxClient;
    }
    public List<String> findPossibleLocations(String location) throws NotFoundException {
        return mapBoxClient.getLocation(location);
    }
}
