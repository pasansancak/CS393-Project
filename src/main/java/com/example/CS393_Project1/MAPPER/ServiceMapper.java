package com.example.CS393_Project1.MAPPER;

import com.example.CS393_Project1.DTO.ServiceDTO;
import com.example.CS393_Project1.ENTITY.E_Service;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceMapper {

    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    ServiceDTO ServicetoServiceDTO(E_Service service);
    E_Service ServiceDTOtoService(ServiceDTO serviceDTO);
}
