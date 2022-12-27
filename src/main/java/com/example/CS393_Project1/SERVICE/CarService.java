package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.ENTITY.Car;
import com.example.CS393_Project1.REPO.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    public Car getCarById(Long id) {
        return carRepo.findById(id).orElse(null);
    }

    public Car saveCar(Car car) {
        return carRepo.save(car);
    }

    public Car updateCar(Long id, Car car) {
        car.setId(id);
        return carRepo.save(car);
    }

    public void deleteCar(Long id) {
        carRepo.deleteById(id);
    }
}
