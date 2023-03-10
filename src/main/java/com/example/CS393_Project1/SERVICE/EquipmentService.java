package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.DTO.EquipmentDTO;
import com.example.CS393_Project1.ENTITY.Equipment;
import com.example.CS393_Project1.ENTITY.Equipment;
import com.example.CS393_Project1.MAPPER.EquipmentMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CS393_Project1.REPO.EquipmentRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Transactional
    public EquipmentDTO getEquipmentById(int id) {
        Equipment equipment = equipmentRepo.findById(id);
        return EquipmentMapper.INSTANCE.EquipmenttoEquipmentDTO(equipment);
    }

    @Transactional
    public EquipmentDTO  saveEquipment(EquipmentDTO equipmentDTO) {
        Equipment equipment = EquipmentMapper.INSTANCE.EquipmentDTOtoEquipment(equipmentDTO);
        equipmentRepo.save(equipment);
        return equipmentDTO;
    }

    @Transactional
    public List<EquipmentDTO> getAllEquipments() {
        List<Equipment> equipments = equipmentRepo.findAll();
        List<EquipmentDTO> equipmentDTOs = new ArrayList<>();
        for (Equipment equipment : equipments){ equipmentDTOs.add(EquipmentMapper.INSTANCE.EquipmenttoEquipmentDTO(equipment));}
        return equipmentDTOs;
    }

    @Transactional
    public boolean deleteEquipment(int id) {
        Equipment equipment = equipmentRepo.findById(id);
        equipmentRepo.delete(equipment);
        return true;
    }
}
