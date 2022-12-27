package com.example.CS393_Project1.MAPPER;

import com.example.CS393_Project1.DTO.LocationDTO;
import com.example.CS393_Project1.ENTITY.Location;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    LocationDTO LocationtoLocationDTO(Location location);
    Location LocationDTOtoLocation(LocationDTO locationDTO);
}