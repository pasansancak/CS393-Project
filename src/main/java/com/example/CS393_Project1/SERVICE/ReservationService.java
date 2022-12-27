package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.ENTITY.Reservation;
import com.example.CS393_Project1.REPO.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepo.findById(id).orElse(null);
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation reservation) {
        reservation.setId(id);
        return reservationRepo.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepo.deleteById(id);
    }
}