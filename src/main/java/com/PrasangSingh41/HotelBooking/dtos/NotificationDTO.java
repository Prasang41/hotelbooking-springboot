package com.PrasangSingh41.HotelBooking.dtos;

import com.PrasangSingh41.HotelBooking.enums.NotificationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationDTO {

    private Long id;
@NotBlank(message = "Required")
    private String subject;
    @NotBlank(message = "Recipient is required")
    private String recipient;

    private String body;
    private NotificationType type;

    private String bookingReference;
    private LocalDateTime createdAt;



}
