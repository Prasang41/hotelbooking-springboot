package com.PrasangSingh41.HotelBooking.dtos;

import com.PrasangSingh41.HotelBooking.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {
    @NotBlank(message = "Required")
    private String firstName;
    @NotBlank(message = "Required")
    private String lastName;
    @NotBlank(message = "Required")
    private String email;
    @NotBlank(message = "Required")
    private String phoneNumber;

    private UserRole role;
    @NotBlank(message = "Required")
    private String password;
}
