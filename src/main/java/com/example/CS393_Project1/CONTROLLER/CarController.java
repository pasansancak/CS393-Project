package com.example.CS393_Project1.CONTROLLER;


import com.example.CS393_Project1.DTO.CarDTO;
import com.example.CS393_Project1.SERVICE.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }

    @PostMapping
    @Operation(summary = "Create new car", description = "Save new car's info into database")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Car saved successfully")})
    public ResponseEntity<CarDTO> saveCar(@RequestBody CarDTO carDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.saveCar(carDto));
    }


    @GetMapping
    public List<CarDTO> getAllCars() {
        return carService.getAllCars();
    }
/*
    @PutMapping("/{id}")
    public CarDTO updateCar(@PathVariable Long id, @RequestBody CarDto carDto) {
        return carService.updateCar(id, carDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }


*/

    @Operation(summary = "Deletes car", description = "deletes cars by barcode")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "Car successfully deleted", content = @Content(schema = @Schema(implementation = CarDTO.class))),
             @ApiResponse(responseCode = "404", description = "No car found"),
             @ApiResponse(responseCode = "500", description = "Exception Thrown"),
             @ApiResponse(responseCode = "406", description = "Not Acceptable")
             })
    @RequestMapping(value = "car/{barcode}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable String barcode) {
        return ResponseEntity.status(HttpStatus.OK).body(carService.deleteCar(barcode));
    }
}
