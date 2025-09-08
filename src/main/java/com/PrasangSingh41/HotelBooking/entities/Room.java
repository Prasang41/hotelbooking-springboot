package com.PrasangSingh41.HotelBooking.entities;

import com.PrasangSingh41.HotelBooking.enums.RoomType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "Room Number must be valid")
    @Column(unique = true)
    private Integer roomNumber;
@Enumerated(EnumType.STRING)
    private RoomType type;
@DecimalMin(value = "0.1", message = "price per night is required")
    private BigDecimal pricePerNight;
@Min(value = 1, message = "capacity must be 1 or more")
    private Integer capacity;

    private String description;

    private String imageUrl;
}
