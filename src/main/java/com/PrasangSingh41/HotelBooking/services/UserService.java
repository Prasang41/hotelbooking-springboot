package com.PrasangSingh41.HotelBooking.services;

import com.PrasangSingh41.HotelBooking.dtos.LoginRequestDTO;
import com.PrasangSingh41.HotelBooking.dtos.RegisterRequestDTO;
import com.PrasangSingh41.HotelBooking.dtos.Response;
import com.PrasangSingh41.HotelBooking.dtos.UserDTO;
import com.PrasangSingh41.HotelBooking.entities.User;

public interface UserService {
    Response registerUser(RegisterRequestDTO registerRequestDTO);

    Response loginUser(LoginRequestDTO loginRequestDTO);

    Response getAllUsers();

    Response getAccountDetails();


    User getCurrentLoggedInUser();


    Response updateOwnAccount(UserDTO userDTO);
    Response deleteOwnAccount();


    Response getMyBookingHistory();


}
