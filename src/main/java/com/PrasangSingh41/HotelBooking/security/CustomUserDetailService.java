package com.PrasangSingh41.HotelBooking.security;

import com.PrasangSingh41.HotelBooking.entities.User;
import com.PrasangSingh41.HotelBooking.exceptions.NotFoundException;
import com.PrasangSingh41.HotelBooking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findByEmail(username)
                .orElseThrow(()-> new NotFoundException("user not found"));
        return AuthUser.builder()
                .user(user)
                .build();
    }
}
