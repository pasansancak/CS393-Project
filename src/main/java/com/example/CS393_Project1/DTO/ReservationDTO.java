package com.example.CS393_Project1.DTO;

import com.example.CS393_Project1.ENTITY.Reservation;

import java.util.Date;

public class ReservationDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getPickupDateTime() {
        return pickupDateTime;
    }

    public void setPickupDateTime(Date pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    public Date getDropoffDateTime() {
        return dropoffDateTime;
    }

    public void setDropoffDateTime(Date dropoffDateTime) {
        this.dropoffDateTime = dropoffDateTime;
    }

    public LocationDTO getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(LocationDTO pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public LocationDTO getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(LocationDTO dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Reservation.ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(Reservation.ReservationStatus status) {
        this.status = status;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

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