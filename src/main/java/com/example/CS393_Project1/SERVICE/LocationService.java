package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.ENTITY.Location;
import com.example.CS393_Project1.REPO.LocationRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepo locationRepo;

    public List<Location> getAllLocations() {
        return locationRepo.findAll();
    }

    public Location getLocationById(Long id) {
        return locationRepo.findById(id).orElse(null);
    }

    public Location saveLocation(Location location) {
        return locationRepo.save(location);
    }

    public Location updateLocation(Long id, Location location) {
        location.setId(id);
        return locationRepo.save(location);
    }

    public void deleteLocation(Long id) {
        locationRepo.deleteById(id);
    }
}