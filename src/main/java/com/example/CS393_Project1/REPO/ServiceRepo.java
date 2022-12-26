package com.example.CS393_Project1.REPO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ServiceRepo extends JpaRepository<Service, Long> {
}