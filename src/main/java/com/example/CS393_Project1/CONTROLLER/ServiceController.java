package com.example.CS393_Project1.CONTROLLER;


import com.example.CS393_Project1.DTO.ServiceDTO;
import com.example.CS393_Project1.ENTITY.E_Service;
import com.example.CS393_Project1.SERVICE.ServiceService;
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
@RequestMapping(value = "/services")
@CrossOrigin
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @GetMapping("/{id}")
    @Operation(summary = "Find service by ID", description = "Returns a single service")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "service successfully found", content = @Content(schema = @Schema(implementation = ServiceDTO.class))),
            @ApiResponse(responseCode = "404", description = "No service found")})
    public ResponseEntity<ServiceDTO> getService(@PathVariable("id") Integer id) {
        ServiceDTO c = serviceService.getServiceById(id);
        if (c != null) {
            return ResponseEntity.status(HttpStatus.OK).body(c);
        }
        return ResponseEntity.status(404).body(null);
    }

    @PostMapping
    @Operation(summary = "Create new service", description = "Save new service's info into database")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "service saved successfully")})
    public ResponseEntity<ServiceDTO> saveService(@RequestBody ServiceDTO serviceDto) {
        return ResponseEntity.status(201).body(serviceService.saveService(serviceDto));
    }

    @GetMapping
    @Operation(summary = "Get all services", description = "Returns all services")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "services successfully returned", content = @Content(schema = @Schema(implementation = ServiceDTO.class))),
            @ApiResponse(responseCode = "404", description = "No service found"),
            @ApiResponse(responseCode = "500", description = "Exception Thrown")})
    public ResponseEntity<List<ServiceDTO>> getAllServices() {
        List<ServiceDTO> c = serviceService.getAllServices();
        try {
            if (c != null) {
                return ResponseEntity.status(HttpStatus.OK).body(c);
            }
            return ResponseEntity.status(404).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(c);
        }
    }

/*
    @PutMapping("/{id}")
    public serviceDTO updateservice(@PathVariable Long id, @RequestBody serviceDto serviceDto) {
        return serviceService.updateservice(id, serviceDto);
    }

*/


    @Operation(summary = "Deletes service", description = "deletes services by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "service successfully deleted", content = @Content(schema = @Schema(implementation = ServiceDTO.class))),
            @ApiResponse(responseCode = "404", description = "No service found")
    })
    @RequestMapping(value = "services/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        boolean s = serviceService.deleteService(id);
        if (s) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        return ResponseEntity.status(404).body(false);
    }
}

