package com.example.CS393_Project1.DTO;

import com.example.CS393_Project1.ENTITY.Car;

public class CarDTO {

    private int id;
    private String barcodeNumber;
    private String licensePlateNumber;
    private Integer passengerCapacity;
    private String brand;
    private String model;
    private Integer mileage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Car.CarType getType() {
        return type;
    }

    public void setType(Car.CarType type) {
        this.type = type;
    }

    public Car.CarStatus getStatus() {
        return status;
    }

    public void setStatus(Car.CarStatus status) {
        this.status = status;
    }

    private String transmissionType;
    private Double dailyPrice;
    private Car.CarType type;
    private Car.CarStatus status;

}