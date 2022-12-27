package com.example.CS393_Project1.MAPPER;

import com.example.CS393_Project1.DTO.EquipmentDTO;
import com.example.CS393_Project1.ENTITY.Equipment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EquipmentMapper {

    EquipmentMapper INSTANCE = Mappers.getMapper(EquipmentMapper.class);

    EquipmentDTO EquipmenttoEquipmentDTO(Equipment equipment);
    Equipment EquipmentDTOtoEquipment(EquipmentDTO equipmentDTO);
}