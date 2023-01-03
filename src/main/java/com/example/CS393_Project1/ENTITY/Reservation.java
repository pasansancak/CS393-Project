package com.example.CS393_Project1.ENTITY;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RESERVATIONS")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 8)
    private int reservationNumber;

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
    private ReservationStatus status=ReservationStatus.NONE;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToMany
    private List<Equipment> equipments = new ArrayList<>();
    @ManyToMany
    private List<E_Service> services = new ArrayList<>();

    public enum ReservationStatus {
        ACTIVE,
        PENDING,
        CONFIRMED,
        COMPLETED,
        CANCELLED,
        NONE
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
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

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(Location dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<E_Service> getServices() {
        return services;
    }

    public void setServices(List<E_Service> services) {
        this.services = services;
    }
}