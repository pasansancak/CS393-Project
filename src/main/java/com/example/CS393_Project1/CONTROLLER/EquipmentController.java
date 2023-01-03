package com.example.CS393_Project1.CONTROLLER;

import com.example.CS393_Project1.DTO.EquipmentDTO;
import com.example.CS393_Project1.SERVICE.EquipmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/equipment")
@CrossOrigin
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    @GetMapping("/{id}")
    @Operation(summary = "Find equipment by ID", description = "Returns a single equipment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "equipment successfully found", content = @Content(schema = @Schema(implementation = EquipmentDTO.class))),
            @ApiResponse(responseCode = "404", description = "No equipment found") })
    public ResponseEntity<EquipmentDTO> getEquipment(@PathVariable("id") Integer id){
        EquipmentDTO c = equipmentService.getEquipmentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }

    @PostMapping
    @Operation(summary = "Create new equipment", description = "Save new equipment's info into database")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Equipment saved successfully")})
    public ResponseEntity<EquipmentDTO> saveEquipment(@RequestBody EquipmentDTO equipmentDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(equipmentService.saveEquipment(equipmentDto));
    }


    @GetMapping
    @Operation(summary = "Get all equipments", description = "Returns all equipments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "equipments successfully returned", content = @Content(schema = @Schema(implementation = EquipmentDTO.class))),
            @ApiResponse(responseCode = "404", description = "No equipment found"),
            @ApiResponse(responseCode = "500", description = "Exception Thrown")})
    public ResponseEntity<List<EquipmentDTO>> getAllEquipments() {
        List<EquipmentDTO> c = equipmentService.getAllEquipments();
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }


    @Operation(summary = "Deletes equipment", description = "deletes equipments by barcode")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipment successfully deleted", content = @Content(schema = @Schema(implementation = EquipmentDTO.class))),
            @ApiResponse(responseCode = "404", description = "No equipment found")
    })
    @RequestMapping(value = "cars/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
       boolean s = equipmentService.deleteEquipment(id);
       if (s) {return ResponseEntity.status(HttpStatus.OK).body((s));}
       return ResponseEntity.status(404).body(false);
    }
}
