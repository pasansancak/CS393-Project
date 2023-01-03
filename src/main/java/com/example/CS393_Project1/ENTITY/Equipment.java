package com.example.CS393_Project1.ENTITY;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EQUIPMENTS")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToMany(mappedBy = "equipments")
    @Column(name = "reservations")
    private List<Reservation> reservations = new ArrayList<>();

    public Equipment() {
    }

    public Equipment(int id, String name, Double price, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.reservations = reservations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public enum name {
        SNOW_TYRES,
        CHILD_SEAT,
        BABY_SEAT,
        ROOF_BOX,
        WIFI,
        GPS
    }
}