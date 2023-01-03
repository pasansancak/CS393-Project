package com.example.CS393_Project1.CONTROLLER;

import com.example.CS393_Project1.DTO.ReservationDTO;
import com.example.CS393_Project1.SERVICE.ReservationService;
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
@RequestMapping(value = "/reservation")
@CrossOrigin
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping("/{id}")
    @Operation(summary = "Find reservation by ID", description = "Returns a single reservation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "reservation successfully found", content = @Content(schema = @Schema(implementation = ReservationDTO.class))),
            @ApiResponse(responseCode = "404", description = "No reservation found") })
    public ResponseEntity<ReservationDTO> getReservation(@PathVariable("id") int id){
        ReservationDTO c = reservationService.getReservationById(id);
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }

    @PostMapping
    @Operation(summary = "Create new reservation", description = "Save new reservation's info into database")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Reservation saved successfully")})
    public ResponseEntity<ReservationDTO> saveReservation(@RequestBody ReservationDTO reservationDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.saveReservation(reservationDto));
    }


    @GetMapping
    @Operation(summary = "Get all reservations", description = "Returns all reservations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "reservations successfully returned", content = @Content(schema = @Schema(implementation = ReservationDTO.class))),
            @ApiResponse(responseCode = "404", description = "No reservation found"),
            @ApiResponse(responseCode = "500", description = "Exception Thrown")})
    public ResponseEntity<List<ReservationDTO>> getAllReservation() {
        List<ReservationDTO> c = reservationService.getAllReservations();
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }

    @Operation(summary = "Deletes reservations", description = "deletes reservations by barcode")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation successfully deleted", content = @Content(schema = @Schema(implementation = ReservationDTO.class))),
            @ApiResponse(responseCode = "404", description = "No reservation found")
    })
    @RequestMapping(value = "reservations/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.deleteReservation(id));
    }


    @PostMapping(value="reservation/{id}")
    @Operation(summary = "Cancel reservation", description = "Cancel reservation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "reservations successfully cancelled", content = @Content(schema = @Schema(implementation = ReservationDTO.class))),
            @ApiResponse(responseCode = "404", description = "No reservation found"),
            @ApiResponse(responseCode = "500", description = "Exception Thrown")})
    public ResponseEntity<Boolean> cancelReservation(@PathVariable("id") int id){
        try{
            Boolean response=reservationService.cancelReservation(id);
            if(response){
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @PutMapping(value="reservation/{reservationNumber}/{eqId}")
    @Operation(summary = "Add new equipment", description = "Add new equipment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipment successfully added", content = @Content(schema = @Schema(implementation = ReservationDTO.class))),
            @ApiResponse(responseCode = "404", description = "No reservation found"),
            @ApiResponse(responseCode = "500", description = "Exception Thrown")})
    public ResponseEntity<Boolean> addEquipment(@PathVariable("reservationNumber")  int resId, @PathVariable("eqId")  int eqId){
        try{
            Boolean response=reservationService.addEquipment(eqId, resId);
            if(response){
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }

    }

    @PutMapping(value="reservation/{reservationNumber}/{servId}")
    @Operation(summary = "Add new equipment", description = "Add new equipment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipment successfully added", content = @Content(schema = @Schema(implementation = ReservationDTO.class))),
            @ApiResponse(responseCode = "404", description = "No reservation found"),
            @ApiResponse(responseCode = "500", description = "Exception Thrown")})
    public ResponseEntity<Boolean> addService(@PathVariable("reservationNumber")  int resId, @PathVariable("servId")  int servId){
        try{
            Boolean response=reservationService.addService(servId, resId);
            if(response){
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }


    }


}

