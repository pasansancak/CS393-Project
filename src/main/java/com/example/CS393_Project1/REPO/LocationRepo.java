package com.example.CS393_Project1.REPO;

import com.example.CS393_Project1.ENTITY.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {
}