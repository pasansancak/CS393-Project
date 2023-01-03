package com.example.CS393_Project1.ServiceTests;

import com.example.CS393_Project1.DTO.ReservationDTO;
import com.example.CS393_Project1.ENTITY.Car;
import com.example.CS393_Project1.ENTITY.Reservation;
import com.example.CS393_Project1.MAPPER.ReservationMapper;
import com.example.CS393_Project1.REPO.ReservationRepo;
import com.example.CS393_Project1.SERVICE.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class ReservationServiceTest {

    @Mock
    private ReservationRepo reservationRepo;

    @InjectMocks
    private ReservationService reservationService;

    private Reservation reservation;
    private ReservationDTO reservationDTO;
    private List<Reservation> reservations;
    private List<ReservationDTO> reservationDTOs;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        reservation = new Reservation();
        reservation.setReservationNumber(1);
        reservation.setStatus(Reservation.ReservationStatus.ACTIVE);
        reservation.setCar(new Car());
        reservation.getCar().setStatus(Car.CarStatus.RESERVED);

        reservationDTO = ReservationMapper.INSTANCE.ReservationtoReservationDTO(reservation);

        reservations = new ArrayList<>();
        reservations.add(reservation);

        reservationDTOs = new ArrayList<>();
        reservationDTOs.add(reservationDTO);
    }

    @Test
    void testGetReservationById() {
        when(reservationRepo.findById(anyInt())).thenReturn(reservation);
        ReservationDTO result = reservationService.getReservationById(1);
        assertEquals(reservationDTO, result);
    }

    @Test
    void testSaveReservation() {
        when(reservationRepo.save(reservation)).thenReturn(reservation);
        ReservationDTO result = reservationService.saveReservation(reservationDTO);
        assertEquals(reservationDTO, result);
    }

    @Test
    void testGetAllReservations() {
        when(reservationRepo.findAll()).thenReturn(reservations);
        List<ReservationDTO> result = reservationService.getAllReservations();
        assertEquals(reservationDTOs, result);
    }
}

