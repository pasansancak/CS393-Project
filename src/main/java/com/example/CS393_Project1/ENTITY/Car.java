package com.example.CS393_Project1.ENTITY;

import jakarta.persistence.*;

@Entity
@Table(name = "CARS")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarcodeNumber() {
        return barcodeNumber;
    }

    public void setBarcodeNumber(String barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public Double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(Double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }


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
