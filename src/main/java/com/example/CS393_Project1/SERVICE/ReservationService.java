package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.DTO.ReservationDTO;
import com.example.CS393_Project1.ENTITY.Car;
import com.example.CS393_Project1.ENTITY.Equipment;
import com.example.CS393_Project1.ENTITY.Reservation;
import com.example.CS393_Project1.MAPPER.ReservationMapper;
import com.example.CS393_Project1.REPO.EquipmentRepo;
import com.example.CS393_Project1.REPO.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;

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

    public Boolean cancelReservation(int id) {
        Reservation reservation = reservationRepo.findById(id);
        try {

            if (reservation == null) {
                return false;
            }
            reservation.setStatus(Reservation.ReservationStatus.CANCELLED);
            reservation.getCar().setStatus(Car.CarStatus.AVAILABLE);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public Boolean addEquipment(int eqId, int resId) {
        try {
            Reservation reservation = reservationRepo.findById(resId);
            Equipment equipment = equipmentRepo.findById(eqId);

            if (equipment == null || reservation.getEquipments().contains(equipment)) {
                return false;
            }

            reservation.getEquipments().add(equipment);
            reservationRepo.save(reservation);

            return true;
        } catch (Exception e){
            return false;
        }
    }

}