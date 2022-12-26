package com.example.CS393_Project1.ENTITY;

import jakarta.persistence.*;

@Entity
@Table(name = "EQUIPMENTS")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields and methods as previously defined
    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;


    // Getters and setters for each field

    public enum name {
        SNOW_TYRES,
        CHILD_SEAT,
        BABY_SEAT,
        ROOF_BOX,
        WIFI,
        GPS
    }
}