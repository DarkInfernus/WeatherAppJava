package dev.divyansh.weatherappjava.Controllers;


import dev.divyansh.weatherappjava.Client.MapBoxClient;
import dev.divyansh.weatherappjava.Exceptions.NotFoundException;
import dev.divyansh.weatherappjava.Services.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class LocationController {
    LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/{location}")
    public List<String> findPossibleLocations(@PathVariable("location") String location) throws NotFoundException {
        return locationService.findPossibleLocations(location);
    }
}
