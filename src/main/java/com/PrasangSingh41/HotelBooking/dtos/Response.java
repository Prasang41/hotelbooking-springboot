package com.PrasangSingh41.HotelBooking.dtos;

import com.PrasangSingh41.HotelBooking.entities.Booking;
import com.PrasangSingh41.HotelBooking.dtos.NotificationDTO;
import com.PrasangSingh41.HotelBooking.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.Notification;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    //generic
    private int status;
    private String message;

    //login
    private String token;
    private UserRole role;
    private Boolean active;
    private String expirationTime;
    //user data
    private UserDTO user;
    private List<UserDTO> users;

    //booking data
    private BookingDTO booking;
    private List<BookingDTO> bookings;

    //room data
    private RoomDTO room;
    private List<RoomDTO> rooms;
    //payments Data
    private String transcationId;
    private PaymentDTO payment;
    private List<PaymentDTO> payments;

    //notification data
    private NotificationDTO notification;
    private List<NotificationDTO> notifications;

    private final LocalDateTime timestamp = LocalDateTime.now();
}

