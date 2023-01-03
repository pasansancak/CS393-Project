package com.example.CS393_Project1.CONTROLLER;

import com.example.CS393_Project1.DTO.CarDTO;
import com.example.CS393_Project1.DTO.MemberDTO;
import com.example.CS393_Project1.SERVICE.CarService;
import com.example.CS393_Project1.SERVICE.MemberService;
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
    @RequestMapping(value = "/members")
    @CrossOrigin
    public class MemberController {
        @Autowired
        MemberService memberService;

    @GetMapping("/{id}")
    @Operation(summary = "Find member by ID", description = "Returns a single member")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "member successfully found", content = @Content(schema = @Schema(implementation = MemberDTO.class))),
            @ApiResponse(responseCode = "404", description = "No member found") })
    public ResponseEntity<MemberDTO> getMember(@PathVariable("id") Integer id){
        MemberDTO c = memberService.getMemberById(id);
        return ResponseEntity.status(HttpStatus.OK).body(c);
}

    @PostMapping
    @Operation(summary = "Create new member", description = "Save new member's info into database")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Member saved successfully")})
    public ResponseEntity<MemberDTO> saveMember(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.saveMember(memberDTO));
    }

    @GetMapping
    @Operation(summary = "Get all members", description = "Returns all members")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "members successfully returned", content = @Content(schema = @Schema(implementation = MemberDTO.class))),
            @ApiResponse(responseCode = "404", description = "No member found"),
            @ApiResponse(responseCode = "500", description = "Exception Thrown")})
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        List<MemberDTO> c = memberService.getAllMembers();
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }


    @Operation(summary = "Deletes member", description = "deletes members by barcode")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Member successfully deleted", content = @Content(schema = @Schema(implementation = MemberDTO.class))),
            @ApiResponse(responseCode = "404", description = "No member found"),
            @ApiResponse(responseCode = "500", description = "Exception Thrown"),
            @ApiResponse(responseCode = "406", description = "Not Acceptable")
    })
    @RequestMapping(value = "members/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body((id));
    }
}
