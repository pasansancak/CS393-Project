package com.example.CS393_Project1.CONTROLLER;


import com.example.CS393_Project1.DTO.CarDTO;
import com.example.CS393_Project1.ENTITY.Car;
import com.example.CS393_Project1.SERVICE.CarService;
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
@RequestMapping(value = "/cars")
@CrossOrigin
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/{id}")
    @Operation(summary = "Find car by ID", description = "Returns a single car")
    @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "car successfully found", content = @Content(schema = @Schema(implementation = CarDTO.class))),
             @ApiResponse(responseCode = "404", description = "No car found") })
    public ResponseEntity<CarDTO>  getCar(@PathVariable("id") Integer id){
        CarDTO c = carService.getCarById(id);
        if (c !=null){ return ResponseEntity.status(HttpStatus.OK).body(c); }
        return ResponseEntity.status(404).body(null);
    }

    @PostMapping
    @Operation(summary = "Create new car", description = "Save new car's info into database")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Car saved successfully")})
    public ResponseEntity<CarDTO> saveCar(@RequestBody CarDTO carDto) {
        return ResponseEntity.status(201).body(carService.saveCar(carDto));
    }

    @GetMapping
    @Operation(summary = "Get all cars", description = "Returns all cars")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "cars successfully returned", content = @Content(schema = @Schema(implementation = CarDTO.class))),
            @ApiResponse(responseCode = "404", description = "No car found"),
            @ApiResponse(responseCode = "500", description = "Exception Thrown")})
    public ResponseEntity<List<CarDTO>> getAllCars() {
        List<CarDTO> c = carService.getAllCars();
        try {
            if (c != null) {
                return ResponseEntity.status(HttpStatus.OK).body(c);
            }
            return ResponseEntity.status(404).body(null);
        } catch (Exception e){
            return ResponseEntity.status(500).body(c);
        }
    }

    @GetMapping(value = "/{type}/{transmissionType}}")
    @Operation(summary = "Search available cars", description = "Returns cars according availability, carType and transmissionType")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Available cars are found", content = @Content(schema = @Schema(implementation = CarDTO.class))),
            @ApiResponse(responseCode = "404", description = "No available cars") })
    public ResponseEntity<List<CarDTO>>  searchAvailableCars(@PathVariable("type") Car.CarType carType, @PathVariable("transmissionType") String transmissionType){
        List<CarDTO> c = carService.searchAvailableCars(carType, transmissionType);
        if (c !=null){ return ResponseEntity.status(HttpStatus.OK).body(c); }
        return ResponseEntity.status(404).body(null);
    }
/*
    @PutMapping("/{id}")
    public CarDTO updateCar(@PathVariable Long id, @RequestBody CarDto carDto) {
        return carService.updateCar(id, carDto);
    }

*/

    @Operation(summary = "Deletes car", description = "deletes cars by barcode")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "Car successfully deleted", content = @Content(schema = @Schema(implementation = CarDTO.class))),
             @ApiResponse(responseCode = "404", description = "No car found"),
             @ApiResponse(responseCode = "500", description = "Exception Thrown"),
             @ApiResponse(responseCode = "406", description = "Not Acceptable")
             })
    @RequestMapping(value = "cars/{barcodeNumber}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("barcodeNumber") String barcode) {
        boolean s = carService.deleteCar(barcode);
        try {
            if (s) {return ResponseEntity.status(HttpStatus.OK).body(true);}
            return ResponseEntity.status(404).body(false);
        } catch (Exception e){
            return ResponseEntity.status(500).body(s);
        }
    }
}
