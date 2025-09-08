package com.PrasangSingh41.HotelBooking.controllers;

import com.PrasangSingh41.HotelBooking.dtos.LoginRequestDTO;
import com.PrasangSingh41.HotelBooking.dtos.RegisterRequestDTO;
import com.PrasangSingh41.HotelBooking.dtos.Response;
import com.PrasangSingh41.HotelBooking.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody @Valid RegisterRequestDTO request){

        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> loginUser(@RequestBody @Valid LoginRequestDTO request){
        return ResponseEntity.ok(userService.loginUser(request));
    }


}