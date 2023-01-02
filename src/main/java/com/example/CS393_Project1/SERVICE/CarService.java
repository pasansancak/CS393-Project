package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.DTO.CarDTO;
import com.example.CS393_Project1.ENTITY.Car;
import com.example.CS393_Project1.MAPPER.CarMapper;
import com.example.CS393_Project1.REPO.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    public CarDTO getCarById(int id) {
        Car car = carRepo.findById(id);
        return CarMapper.INSTANCE.carToCarDto(car);
    }

    public CarDTO saveCar(CarDTO CarDTO) {
        Car car = CarMapper.INSTANCE.CarDTOtoCar(CarDTO);
        carRepo.save(car);
        return CarMapper.INSTANCE.carToCarDto(car);
    }

    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepo.findAll();
        List<CarDTO> carDTOs = new ArrayList<>();
        for (Car car : cars){ carDTOs.add(CarMapper.INSTANCE.carToCarDto(car)); }
        return carDTOs;
    }

    public boolean deleteCar(String barcode) {
        Car car = carRepo.findByBarcodeNumber(barcode);
        if (Objects.equals(car.getStatus().toString(), "AVAILABLE")){
            carRepo.delete(car);
            return true;
        }
        return false;
    }
}
