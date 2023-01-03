package com.example.CS393_Project1.ServiceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.example.CS393_Project1.DTO.LocationDTO;
import com.example.CS393_Project1.ENTITY.Location;
import com.example.CS393_Project1.MAPPER.LocationMapper;
import com.example.CS393_Project1.REPO.LocationRepo;
import com.example.CS393_Project1.SERVICE.LocationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LocationServiceTest {

    @Mock
    private LocationRepo locationRepo;

    @InjectMocks
    private LocationService locationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetLocationById() {
        // given
        String id = "1";
        Location location = new Location();
        location.setCode(id);
        LocationDTO locationDTO = LocationMapper.INSTANCE.LocationtoLocationDTO(location);
        when(locationRepo.findById(Integer.parseInt(id))).thenReturn(location);

        // when
        LocationDTO result = locationService.getLocationById(Integer.parseInt(id));

        // then
        assertThat(result).isEqualTo(locationDTO);
    }

    @Test
    void testSaveLocation() {
        // given
        int id = 1;
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(id);
        Location location = LocationMapper.INSTANCE.LocationDTOtoLocation(locationDTO);
        when(locationRepo.save(location)).thenReturn(location);

        // when
        LocationDTO result = locationService.saveLocation(locationDTO);

        // then
        assertThat(result).isEqualTo(locationDTO);
    }

    @Test
    void testGetAllLocations() {
        // given
        List<Location> locations = new ArrayList<>();
        Location location1 = new Location();
        location1.setCode("1");
        Location location2 = new Location();
        location2.setCode("2");
        locations.add(location1);
        locations.add(location2);
        when(locationRepo.findAll()).thenReturn(locations);

        // when
        List<LocationDTO> result = locationService.getAllLocations();

        // then
        assertThat(result).hasSize(2);
        assertThat(result).contains(LocationMapper.INSTANCE.LocationtoLocationDTO(location1),
                LocationMapper.INSTANCE.LocationtoLocationDTO(location2));
    }

    @Test
    void testDeleteLocation() {
        // given
        String id = "1";
        Location location = new Location();
        location.setCode(id);
        when(locationRepo.findById(Integer.parseInt(id))).thenReturn(location);

        // when
        boolean result = locationService.deleteLocation(Integer.parseInt(id));

        // then
        assertThat(result).isTrue();
    }

    @Test
    void testDeleteLocation_invalidId() {
        // given
        int id = 1;
        when(locationRepo.findById(id)).thenReturn(null);

        // when
        assertThrows(IllegalArgumentException.class, () -> locationService.deleteLocation(id));
    }
}

