package com.PrasangSingh41.HotelBooking.entities;

import com.PrasangSingh41.HotelBooking.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Enter Password")
    private String password;
    private String  firstName;
    private String lastName;
    @NotBlank(message = "Enter Phone Number")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private UserRole Role;
    private Boolean isactive;
    private final LocalDateTime createdAt = LocalDateTime.now();

}
