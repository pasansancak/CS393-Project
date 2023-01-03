package com.example.CS393_Project1.ENTITY;

import jakarta.persistence.*;
import java.util.*;
@Entity
@Table(name = "SERVICES")
public class E_Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "price",nullable = false)
    private Double price;

    @ManyToMany(mappedBy = "services")
    @Column(name = "reservations")
    private List<Reservation> reservations = new ArrayList<>();

    public E_Service() {
    }

    public E_Service(int id, String name, Double price, List<Reservation> reservations) {
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



    public enum name {
        ADDITIONAL_DRIVER,
        TOWING_SERVICE,
        ROADSIDE_ASSISTANCE
    }

}