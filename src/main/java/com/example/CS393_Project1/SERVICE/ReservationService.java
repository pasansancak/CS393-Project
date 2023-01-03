package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.DTO.ReservationDTO;
import com.example.CS393_Project1.ENTITY.Reservation;
import com.example.CS393_Project1.ENTITY.Reservation;
import com.example.CS393_Project1.MAPPER.ReservationMapper;
import com.example.CS393_Project1.REPO.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    public ReservationDTO getReservationById(int id) {
        Reservation reservation = reservationRepo.findById(id);
        return ReservationMapper.INSTANCE.ReservationtoReservationDTO(reservation);
    }

    public ReservationDTO saveReservation(ReservationDTO reservationDTO) {
        Reservation reservation = ReservationMapper.INSTANCE.ReservationDTOtoReservation(reservationDTO);
        reservationRepo.save(reservation);
        return ReservationMapper.INSTANCE.ReservationtoReservationDTO(reservation);
    }

    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepo.findAll();
        List<ReservationDTO> reservationDTOs = new ArrayList<>();
        for (Reservation reservation : reservations){ reservationDTOs.add(ReservationMapper.INSTANCE.ReservationtoReservationDTO(reservation));}
        return reservationDTOs;
    }

    public boolean deleteReservation(int id) {
        Reservation reservation = reservationRepo.findById(id);
        reservationRepo.delete(reservation);
        return true;
    }
}