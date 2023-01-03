package com.example.CS393_Project1.ServiceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import com.example.CS393_Project1.DTO.CarDTO;
import com.example.CS393_Project1.ENTITY.Car;
import com.example.CS393_Project1.MAPPER.CarMapper;
import com.example.CS393_Project1.REPO.CarRepo;
import com.example.CS393_Project1.REPO.ReservationRepo;
import com.example.CS393_Project1.SERVICE.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class CarServiceTest {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepo carRepo;


    @Test
    void testGetCarById() {
        Car car = new Car();
        car.setBarcodeNumber("123456");
        car.setLicensePlateNumber("ABC123");
        car.setPassengerCapacity(4);
        car.setBrand("Toyota");
        car.setModel("Camry");
        car.setMileage(20000);
        car.setTransmissionType("Automatic");
        car.setDailyPrice(50.0);
        car.setType(Car.CarType.ECONOMY);
        car.setStatus(Car.CarStatus.AVAILABLE);
        carRepo.save(car);

        CarDTO carDTO = carService.getCarById(car.getId());

        assertEquals(car.getId(), carDTO.getId());
        assertEquals(car.getBarcodeNumber(), carDTO.getBarcodeNumber());
        assertEquals(car.getLicensePlateNumber(), carDTO.getLicensePlateNumber());
        assertEquals(car.getPassengerCapacity(), carDTO.getPassengerCapacity());
        assertEquals(car.getBrand(), carDTO.getBrand());
        assertEquals(car.getModel(), carDTO.getModel());
        assertEquals(car.getMileage(), carDTO.getMileage());
        assertEquals(car.getTransmissionType(), carDTO.getTransmissionType());
        assertEquals(car.getDailyPrice(), carDTO.getDailyPrice());
        assertEquals(car.getType(), carDTO.getType());
        assertEquals(car.getStatus(), carDTO.getStatus());
    }
    @Test
    void testSaveCar() {
        // create a car DTO with some values
        CarDTO carDTO = new CarDTO(0, "123456", "ABC123", 4, "Toyota", "Camry", 20000, "Automatic", 50.0, Car.CarType.ECONOMY, Car.CarStatus.AVAILABLE);

        // save the car using the car service
        carDTO = carService.saveCar(carDTO);

        // verify that the returned car DTO has a non-zero id
        assertTrue(carDTO.getId() > 0);

        // verify that the car was saved to the database
        Car car = carRepo.findById(carDTO.getId());
        assertNotNull(car);
        assertEquals(carDTO.getId(), car.getId());
        assertEquals(carDTO.getBarcodeNumber(), car.getBarcodeNumber());
        assertEquals(carDTO.getLicensePlateNumber(), car.getLicensePlateNumber());
    }

    @Test
    void testGetAllCars() {
// create some cars and save them to the database
        Car car1 = new Car();
        car1.setBarcodeNumber("123456");
        car1.setLicensePlateNumber("ABC123");
        car1.setPassengerCapacity(4);
        car1.setBrand("Toyota");
        car1.setModel("Camry");
        car1.setMileage(20000);
        car1.setTransmissionType("Automatic");
        car1.setDailyPrice(50.0);
        car1.setType(Car.CarType.ECONOMY);
        car1.setStatus(Car.CarStatus.AVAILABLE);
        carRepo.save(car1);
        Car car2 = new Car();
        car2.setBarcodeNumber("123457");
        car2.setLicensePlateNumber("ABC124");
        car2.setPassengerCapacity(5);
        car2.setBrand("Honda");
        car2.setModel("Civic");
        car2.setMileage(30000);
        car2.setTransmissionType("Automatic");
        car2.setDailyPrice(60.0);
        car2.setType(Car.CarType.STANDARD);
        car2.setStatus(Car.CarStatus.AVAILABLE);
        carRepo.save(car2);

        // get all cars using the car service
        List<CarDTO> carDTOs = carService.getAllCars();

        // verify that the returned list contains the correct number of cars
        assertEquals(2, carDTOs.size());

        // verify that the returned list contains the correct cars
        assertTrue(carDTOs.contains(CarMapper.INSTANCE.carToCarDto(car1)));
        assertTrue(carDTOs.contains(CarMapper.INSTANCE.carToCarDto(car2)));
    }

}