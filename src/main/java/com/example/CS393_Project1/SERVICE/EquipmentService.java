package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.DTO.EquipmentDTO;
import com.example.CS393_Project1.ENTITY.Equipment;
import com.example.CS393_Project1.ENTITY.Equipment;
import com.example.CS393_Project1.MAPPER.EquipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CS393_Project1.REPO.EquipmentRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepo equipmentRepo;

    public EquipmentDTO getEquipmentById(int id) {
        Equipment equipment = equipmentRepo.findById(id);
        return EquipmentMapper.INSTANCE.EquipmenttoEquipmentDTO(equipment);
    }

    public void saveEquipment(EquipmentDTO equipmentDTO) {
        Equipment equipment = EquipmentMapper.INSTANCE.EquipmentDTOtoEquipment(equipmentDTO);
        equipmentRepo.save(equipment);
    }

    public List<EquipmentDTO> getAllEquipments() {
        List<Equipment> equipments = equipmentRepo.findAll();
        List<EquipmentDTO> equipmentDTOs = new ArrayList<>();
        for (Equipment equipment : equipments){ equipmentDTOs.add(EquipmentMapper.INSTANCE.EquipmenttoEquipmentDTO(equipment));}
        return equipmentDTOs;
    }

    public void deleteEquipment(int id) {
        Equipment equipment = equipmentRepo.findById(id);
        equipmentRepo.delete(equipment);
    }
}
