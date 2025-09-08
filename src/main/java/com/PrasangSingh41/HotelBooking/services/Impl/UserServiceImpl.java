package com.PrasangSingh41.HotelBooking.services.Impl;

import com.PrasangSingh41.HotelBooking.dtos.*;
import com.PrasangSingh41.HotelBooking.entities.Booking;
import com.PrasangSingh41.HotelBooking.entities.User;
import com.PrasangSingh41.HotelBooking.enums.UserRole;
import com.PrasangSingh41.HotelBooking.exceptions.InvalidCredentialException;
import com.PrasangSingh41.HotelBooking.exceptions.NotFoundException;
import com.PrasangSingh41.HotelBooking.repository.BookingRepository;
import com.PrasangSingh41.HotelBooking.repository.UserRepository;
import com.PrasangSingh41.HotelBooking.security.JwtUtils;
import com.PrasangSingh41.HotelBooking.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final ModelMapper modelMapper;
    private final BookingRepository bookingRepository;
    @Override
    public Response registerUser(RegisterRequestDTO registerRequestDTO) {
        UserRole role= UserRole.CUSTOMERS;
        if(registerRequestDTO.getRole()!=null)
        {
            role = registerRequestDTO.getRole();
        }
        User userToSave = User.builder()
                .firstName(registerRequestDTO.getFirstName())
                .lastName(registerRequestDTO.getLastName())
                .email(registerRequestDTO.getEmail())
                .password(passwordEncoder.encode(registerRequestDTO.getPassword()))
                .phoneNumber(registerRequestDTO.getPhoneNumber())
                .Role(role)
                .isactive(true)
                .build();

        userRepository.save(userToSave);
        return Response.builder()
                .status(200)
                .message("User Registration Successfull")
                .build();
    }

    @Override
    public Response loginUser(LoginRequestDTO loginRequestDTO) {
        User user=userRepository.findByEmail(loginRequestDTO.getEmail()).orElseThrow(()->new NotFoundException("Email Not Found"));
        if(!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())){
            throw new InvalidCredentialException("Wrong Password");
        }
        String token = jwtUtils.generateToken(user.getEmail());
        return Response.builder().status(200)
                .message("Login Successfull")
                .role(user.getRole())
                .token(token)
                .active(user.getIsactive())
                .expirationTime("6 months")
                .build();
    }

    @Override
    public Response getAllUsers() {
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        List<UserDTO> userDTOList = modelMapper.map(users , new TypeToken<List<UserDTO>>(){}.getType());
        return Response.builder()
                .status(200)
                .message("success")
                .users(userDTOList).
                build();
    }

    @Override
    public Response getAccountDetails() {
        log.info("INSIDE Own Account");
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(()-> new NotFoundException("User Not Found"));

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return Response.builder()
                .status(200)
                .message("success")
                .user(userDTO).build();
    }

    @Override
    public User getCurrentLoggedInUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByEmail(email)
                .orElseThrow(()-> new NotFoundException("User Not Found"));
    }


    @Override
    public Response updateOwnAccount(UserDTO userDTO) {
        User existingUser = getCurrentLoggedInUser();
        log.info("Inside update user");

        if (userDTO.getEmail() != null) existingUser.setEmail(userDTO.getEmail());
        if (userDTO.getFirstName() != null) existingUser.setFirstName(userDTO.getFirstName());
        if (userDTO.getLastName() != null) existingUser.setLastName(userDTO.getLastName());
        if (userDTO.getPhoneNumber() != null) existingUser.setPhoneNumber(userDTO.getPhoneNumber());

        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        userRepository.save(existingUser);

        return Response.builder()
                .status(200)
                .message("user updated successfully")
                .build();
    }

    @Override
    public Response deleteOwnAccount() {
        User user = getCurrentLoggedInUser();
        userRepository.delete(user);

        return Response.builder()
                .status(200)
                .message("user deleted successfully")
                .build();
    }

    @Override
    public Response getMyBookingHistory() {

        User user = getCurrentLoggedInUser();

        List<Booking> bookingList = bookingRepository.findByUserId(user.getId());


        List<BookingDTO> bookingDTOList = modelMapper.map(bookingList, new TypeToken<List<BookingDTO>>(){}.getType());

        return Response.builder()
                .status(200)
                .message("success")
                .bookings(bookingDTOList)
                .build();

    }
}
