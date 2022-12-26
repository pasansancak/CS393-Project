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

    // Getters and setters for each field


    public enum name {
        ADDITIONAL_DRIVER,
        TOWING_SERVICE,
        ROADSIDE_ASSISTANCE
    }

}