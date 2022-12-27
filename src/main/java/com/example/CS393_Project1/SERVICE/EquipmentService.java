package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.ENTITY.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CS393_Project1.REPO.EquipmentRepo;
import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepo equipmentRepo;

    public List<Equipment> getAllEquipment() {
        return equipmentRepo.findAll();
    }

    public Equipment getEquipmentById(Long id) {
        return equipmentRepo.findById(id).orElse(null);
    }

    public Equipment saveEquipment(Equipment equipment) {
        return equipmentRepo.save(equipment);
    }

    public Equipment updateEquipment(Long id, Equipment equipment) {
        equipment.setId(id);
        return equipmentRepo.save(equipment);
    }

    public void deleteEquipment(Long id) {
        equipmentRepo.deleteById(id);
    }
}
