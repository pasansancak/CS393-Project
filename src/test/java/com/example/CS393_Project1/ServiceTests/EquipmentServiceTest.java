package com.example.CS393_Project1.ServiceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.CS393_Project1.DTO.EquipmentDTO;
import com.example.CS393_Project1.ENTITY.Equipment;
import com.example.CS393_Project1.REPO.EquipmentRepo;
import com.example.CS393_Project1.SERVICE.EquipmentService;

class EquipmentServiceTest {
    @Mock
    private EquipmentRepo equipmentRepo;

    private EquipmentService equipmentService;

    @BeforeEach
    void setUp() {
        equipmentRepo = mock(EquipmentRepo.class);
        equipmentService = new EquipmentService();

    }

    @Test
    void getEquipmentById_shouldReturnEquipmentDTO() {
        // Given
        int id = 1;
        Equipment equipment = new Equipment();
        equipment.setId(id);
        equipment.setName("Car");
        when(equipmentRepo.findById(id)).thenReturn(equipment);

        // When
        EquipmentDTO equipmentDTO = equipmentService.getEquipmentById(id);

        // Then
        assertThat(equipmentDTO).isNotNull();
        assertThat(equipmentDTO.getId()).isEqualTo(id);
        assertThat(equipmentDTO.getName()).isEqualTo("Car");
    }

    @Test
    void saveEquipment_shouldSaveEquipment() {
        // Given
        EquipmentDTO equipmentDTO = new EquipmentDTO();
        equipmentDTO.setName("Car");
        Equipment equipment = new Equipment();
        equipment.setName("Car");
        when(equipmentRepo.save(equipment)).thenReturn(equipment);

        // When
        EquipmentDTO savedEquipmentDTO = equipmentService.saveEquipment(equipmentDTO);

        // Then
        assertThat(savedEquipmentDTO).isNotNull();
        assertThat(savedEquipmentDTO.getName()).isEqualTo("Car");
    }

    @Test
    void getAllEquipments_shouldReturnListOfEquipmentDTOs() {
        // Given
        Equipment equipment1 = new Equipment();
        equipment1.setId(1);
        equipment1.setName("Car");
        Equipment equipment2 = new Equipment();
        equipment2.setId(2);
        equipment2.setName("Bike");
        List<Equipment> equipments = new ArrayList<>();
        equipments.add(equipment1);
        equipments.add(equipment2);
        when(equipmentRepo.findAll()).thenReturn(equipments);

        // When
        List<EquipmentDTO> equipmentDTOs = equipmentService.getAllEquipments();

    }

    @Test
    void deleteEquipment_shouldDeleteEquipment() {
        // Given
        int id = 1;
        Equipment equipment = new Equipment();
        equipment.setId(id);
        when(equipmentRepo.findById(id)).thenReturn(equipment);

        // When
        boolean success = equipmentService.deleteEquipment(id);

        // Then
        assertThat(success).isTrue();
    }
}





