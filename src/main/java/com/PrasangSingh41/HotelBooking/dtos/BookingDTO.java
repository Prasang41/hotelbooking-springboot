package com.PrasangSingh41.HotelBooking.dtos;

import com.PrasangSingh41.HotelBooking.entities.Room;
import com.PrasangSingh41.HotelBooking.entities.User;
import com.PrasangSingh41.HotelBooking.enums.BookingStatus;
import com.PrasangSingh41.HotelBooking.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

    private Long id;

    private UserDTO user;

    private RoomDTO room;
    private Long roomId;
    private PaymentStatus paymentStatus;


    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private BigDecimal totalPrice;

    private String bookingReference;

    private LocalDate createdAt;
    private BookingStatus bookingStatus;

}
