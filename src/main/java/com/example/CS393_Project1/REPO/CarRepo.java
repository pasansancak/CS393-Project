package com.example.CS393_Project1.REPO;

import com.example.CS393_Project1.ENTITY.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
    Car findById(int id);
}

