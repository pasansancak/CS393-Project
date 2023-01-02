package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.DTO.ServiceDTO;
import com.example.CS393_Project1.ENTITY.E_Service;
import com.example.CS393_Project1.MAPPER.ServiceMapper;
import com.example.CS393_Project1.REPO.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepo serviceRepo;

    public ServiceDTO getServiceById(int id) {
        E_Service service = serviceRepo.findById(id);
        return ServiceMapper.INSTANCE.ServicetoServiceDTO(service);
    }

    public void saveService(ServiceDTO serviceDTO) {
        E_Service service = ServiceMapper.INSTANCE.ServiceDTOtoService(serviceDTO);
        serviceRepo.save(service);
    }

    public List<ServiceDTO> getAllServices() {
        List<E_Service> services = serviceRepo.findAll();
        List<ServiceDTO> serviceDTOs = new ArrayList<>();
        for (E_Service service : services){ serviceDTOs.add(ServiceMapper.INSTANCE.ServicetoServiceDTO(service));}
        return serviceDTOs;
    }

    public void deleteService(int id) {
        E_Service service = serviceRepo.findById(id);
        serviceRepo.delete(service);
    }
}