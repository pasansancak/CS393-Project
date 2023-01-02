package com.example.CS393_Project1.REPO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.CS393_Project1.ENTITY.E_Service;

@Repository
public interface ServiceRepo extends JpaRepository<E_Service, Integer> {
    E_Service findById(int id);
}