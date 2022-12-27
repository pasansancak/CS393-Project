package com.example.CS393_Project1.MAPPER;

import com.example.CS393_Project1.DTO.ReservationDTO;
import com.example.CS393_Project1.ENTITY.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    ReservationDTO ReservationtoReservationDTO(Reservation reservation);
    Reservation ReservationDTOtoReservation(ReservationDTO reservationDTO);
}