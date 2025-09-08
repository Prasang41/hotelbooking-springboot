package com.PrasangSingh41.HotelBooking.entities;

import com.PrasangSingh41.HotelBooking.enums.PaymentGateway;
import com.PrasangSingh41.HotelBooking.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal amount;

    private String transactionId;
@Enumerated(EnumType.STRING)
    private PaymentGateway paymentGateway;

    private LocalDateTime paymentDate;
@Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private String bookingReference;

    private String failureReason;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
