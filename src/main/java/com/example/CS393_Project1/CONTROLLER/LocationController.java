package com.example.CS393_Project1.CONTROLLER;

import com.example.CS393_Project1.DTO.CarDTO;
import com.example.CS393_Project1.DTO.LocationDTO;
import com.example.CS393_Project1.ENTITY.Location;
import com.example.CS393_Project1.SERVICE.CarService;
import com.example.CS393_Project1.SERVICE.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/locations")
@CrossOrigin
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping("/{id}")
    @Operation(summary = "Find location by ID", description = "Returns a single location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "location successfully found", content = @Content(schema = @Schema(implementation = LocationDTO.class))),
            @ApiResponse(responseCode = "404", description = "No location found") })
    public ResponseEntity<LocationDTO> getLocation(@PathVariable("id") Integer id){
        LocationDTO c = locationService.getLocationById(id);
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }

    @PostMapping
    @Operation(summary = "Create new location", description = "Save new location's info into database")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Location saved successfully")})
    public ResponseEntity<LocationDTO> saveLocation(@RequestBody LocationDTO locationDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.saveLocation(locationDto));
    }


    @GetMapping
    @Operation(summary = "Get all locations", description = "Returns all locations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "locations successfully returned", content = @Content(schema = @Schema(implementation = LocationDTO.class))),
            @ApiResponse(responseCode = "404", description = "No location found"),
            @ApiResponse(responseCode = "500", description = "Exception Thrown")})
    public ResponseEntity<List<LocationDTO>> getAllLocations() {
        List<LocationDTO> c = locationService.getAllLocations();
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }


    @Operation(summary = "Deletes location", description = "deletes locations by barcode")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "location successfully deleted", content = @Content(schema = @Schema(implementation = LocationDTO.class))),
            @ApiResponse(responseCode = "404", description = "No location found"),
            @ApiResponse(responseCode = "500", description = "Exception Thrown"),
            @ApiResponse(responseCode = "406", description = "Not Acceptable")
    })
    @RequestMapping(value = "location/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(locationService.deleteLocation(id));
    }
}

