package com.PrasangSingh41.HotelBooking.dtos;

import com.PrasangSingh41.HotelBooking.entities.User;
import com.PrasangSingh41.HotelBooking.enums.PaymentGateway;
import com.PrasangSingh41.HotelBooking.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDTO {

    private Long id;

    private BigDecimal amount;

    private String transactionId;
    private PaymentGateway paymentGateway;

    private LocalDateTime paymentDate;
    private PaymentStatus paymentStatus;

    private String bookingReference;

    private String failureReason;
    private String approvalLink;

}
