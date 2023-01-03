package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.DTO.LocationDTO;
import com.example.CS393_Project1.ENTITY.Location;
import com.example.CS393_Project1.MAPPER.LocationMapper;
import com.example.CS393_Project1.REPO.LocationRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepo locationRepo;

    @Transactional
    public LocationDTO getLocationById(int id) {
        Location location = locationRepo.findById(id);
        return LocationMapper.INSTANCE.LocationtoLocationDTO(location);
    }

    @Transactional
    public LocationDTO saveLocation(LocationDTO locationDTO) {
        Location location = LocationMapper.INSTANCE.LocationDTOtoLocation(locationDTO);
        locationRepo.save(location);
        return LocationMapper.INSTANCE.LocationtoLocationDTO(location);
    }

    @Transactional
    public List<LocationDTO> getAllLocations() {
        List<Location> locations = locationRepo.findAll();
        List<LocationDTO> locationDTOs = new ArrayList<>();
        for (Location location : locations){ locationDTOs.add(LocationMapper.INSTANCE.LocationtoLocationDTO(location));}
        return locationDTOs;
    }

    @Transactional
    public boolean deleteLocation(int id) {
        Location location = locationRepo.findById(id);
        locationRepo.delete(location);
        return true;
    }
}