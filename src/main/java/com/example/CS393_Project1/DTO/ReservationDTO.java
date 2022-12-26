package com.example.CS393_Project1.DTO;

import com.example.CS393_Project1.ENTITY.Reservation;

import java.util.Date;

public class ReservationDTO {

    private Long id;
    private String reservationNumber;
    private CarDTO car;
    private Date creationDate;
    private Date pickupDateTime;
    private Date dropoffDateTime;
    private LocationDTO pickupLocation;
    private LocationDTO dropoffLocation;
    private Date returnDate;
    private Reservation.ReservationStatus status;
    private MemberDTO member;

}