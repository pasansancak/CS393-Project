package com.example.CS393_Project1.ENTITY;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "RESERVATIONS")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reservation_number")
    private String reservationNumber;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "pickup_date_time")
    private Date pickupDateTime;


    @Column(name = "dropoff_date_time")
    private Date dropoffDateTime;

    @ManyToOne
    @JoinColumn(name = "pickup_location_id")
    private Location pickupLocation;

    @ManyToOne
    @JoinColumn(name = "dropoff_location_id")
    private Location dropoffLocation;

    @Column(name = "return_date")
    private Date returnDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReservationStatus status;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // Getters and setters for each field

    public enum ReservationStatus {
        ACTIVE,
        PENDING,
        CONFIRMED,
        COMPLETED,
        CANCELLED,
        NONE
    }
}