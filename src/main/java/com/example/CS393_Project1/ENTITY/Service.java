package com.example.CS393_Project1.ENTITY;

import jakarta.persistence.*;
@Entity
@Table(name = "SERVICES")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "price",nullable = false)
    private Double price;

    public Service() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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