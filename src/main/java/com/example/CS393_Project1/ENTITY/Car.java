package com.example.CS393_Project1.ENTITY;

import jakarta.persistence.*;

@Entity
@Table(name = "CARS")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "barcode_number")
    private String barcodeNumber;

    @Column(name = "license_plate_number")
    private String licensePlateNumber;

    @Column(name = "passenger_capacity")
    private Integer passengerCapacity;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "transmission_type")
    private String transmissionType;

    @Column(name = "daily_price")
    private Double dailyPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CarType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CarStatus status;

    // Getters and setters for each field

    public enum CarType {
        ECONOMY,
        PEOPLE_CARRIER,
        ESTATE,
        SUV,
        STANDARD,
        CONVERTIBLE,
        LUXURY
    }
    public enum CarStatus {
        AVAILABLE,
        RESERVED,
        LOANED,
        LOST,
        BEING_SERVICED
    }
}
