package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.DTO.CarDTO;
import com.example.CS393_Project1.ENTITY.Car;
import com.example.CS393_Project1.ENTITY.Reservation;
import com.example.CS393_Project1.MAPPER.CarMapper;
import com.example.CS393_Project1.REPO.CarRepo;
import com.example.CS393_Project1.REPO.ReservationRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ReservationRepo reservationRepo;

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

    public List<CarDTO> searchAvailableCars(Car.CarType carType, String transmissionType) {
        List<Car> cars = carRepo.findCarsByTypeAndTransmissionType(carType, transmissionType);
        List<CarDTO> carDTOs = new ArrayList<>();
        for (Car car : cars) {
            if (Objects.equals(car.getStatus().toString(), "AVAILABLE")) {
                carDTOs.add(CarMapper.INSTANCE.carToCarDto(car));
            }
        }
        return carDTOs;
    }

    public List<CarDTO> getAllRentedCars() {
        List<Car> cars = carRepo.findAll();
        List<CarDTO> carDTOs = new ArrayList<>();
        for (Car car : cars) {
            if (Objects.equals(car.getStatus().toString(), "LOANED") || Objects.equals(car.getStatus().toString(), "RESERVED")) {
                carDTOs.add(CarMapper.INSTANCE.carToCarDto(car));
            }
        }
        return carDTOs;
    }


    public boolean returnCar(int reservationNumber) {
        Reservation r= reservationRepo.findById(reservationNumber);

        if (r != null  && r.getStatus() == Reservation.ReservationStatus.ACTIVE){

            r.setStatus(Reservation.ReservationStatus.COMPLETED);
            Date date= new java.sql.Date(Calendar.getInstance().getTimeInMillis());
            r.setReturnDate(date);
            r.getCar().setStatus(Car.CarStatus.AVAILABLE);

            return true;
        }
        return false;
    }
}
