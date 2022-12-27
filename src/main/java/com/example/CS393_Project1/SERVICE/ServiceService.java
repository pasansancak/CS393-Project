package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.ENTITY.E_Service;
import com.example.CS393_Project1.REPO.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepo serviceRepo;

    public List<E_Service> getAllServices() {
        return serviceRepo.findAll();
    }

    public E_Service getServiceById(Long id) {
        return serviceRepo.findById(id).orElse(null);
    }

    public E_Service saveService(E_Service service) {
        return serviceRepo.save(service);
    }

    public E_Service updateService(Long id, E_Service service) {
        service.setId(id);
        return serviceRepo.save(service);
    }

    public void deleteService(Long id) {
        serviceRepo.deleteById(id);
    }
}