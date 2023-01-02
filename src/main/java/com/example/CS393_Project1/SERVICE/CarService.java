package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.DTO.CarDTO;
import com.example.CS393_Project1.ENTITY.Car;
import com.example.CS393_Project1.MAPPER.CarMapper;
import com.example.CS393_Project1.REPO.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    public CarDTO getCarById(int id) {
        Car car = carRepo.findById(id);
        return CarMapper.INSTANCE.carToCarDto(car);
    }

    public void saveCar(CarDTO CarDTO) {
        Car car = CarMapper.INSTANCE.CarDTOtoCar(CarDTO);
        carRepo.save(car);
    }

    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepo.findAll();
        List<CarDTO> carDTOs = new ArrayList<>();
        for (Car car : cars){ carDTOs.add(CarMapper.INSTANCE.carToCarDto(car)); }
        return carDTOs;
    }

    public void deleteCar(int id) {
        Car car = carRepo.findById(id);
        carRepo.delete(car);
    }
}
