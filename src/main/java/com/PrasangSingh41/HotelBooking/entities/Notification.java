package com.PrasangSingh41.HotelBooking.entities;

import com.PrasangSingh41.HotelBooking.enums.NotificationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
@NotBlank(message = "Recipient isrequired")
    private String recipient;

    private String body;
@Enumerated(EnumType.STRING)
    private NotificationType type;

    private String bookingReference;
    private final LocalDateTime createdAt = LocalDateTime.now();



}
