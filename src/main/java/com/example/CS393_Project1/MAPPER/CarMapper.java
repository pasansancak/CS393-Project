package com.example.CS393_Project1.MAPPER;

import com.example.CS393_Project1.DTO.CarDTO;
import com.example.CS393_Project1.ENTITY.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    CarDTO carToCarDto(Car car);
    Car CarDTOtoCar(CarDTO carDTO);
}
