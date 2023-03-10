package com.example.CS393_Project1.DTO;

public class EquipmentDTO {

    private int id;
    private String name;
    private Double price;

    public EquipmentDTO(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public EquipmentDTO() {
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
}