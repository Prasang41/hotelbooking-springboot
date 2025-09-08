package com.PrasangSingh41.HotelBooking.services;

import com.PrasangSingh41.HotelBooking.dtos.Response;
import com.PrasangSingh41.HotelBooking.dtos.RoomDTO;
import com.PrasangSingh41.HotelBooking.enums.RoomType;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    Response addRoom(RoomDTO roomDTO, MultipartFile imageFile);

    Response updateRoom(RoomDTO roomDTO, MultipartFile imageFile);

    Response getAllRooms();

    Response getRoomById(Long Id);

    Response deleteRoom(Long Id);

    Response getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate, RoomType roomType);
    List<RoomType> getAllRoomTypes();
    Response searchRoom(String input);

}
