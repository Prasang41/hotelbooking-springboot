package com.PrasangSingh41.HotelBooking.config;

import com.PrasangSingh41.HotelBooking.dtos.UserDTO;
import com.PrasangSingh41.HotelBooking.entities.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(false) // Disable automatic field matching
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STANDARD)
                .setCollectionsMergeEnabled(true); // Handle collections if needed

        // Explicit type map with strict mappings
        modelMapper.createTypeMap(User.class, UserDTO.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getRole(), UserDTO::setRole); // Use getter explicitly
                    mapper.map(src -> src.getId(), UserDTO::setId);
                    mapper.map(src -> src.getEmail(), UserDTO::setEmail);
                    mapper.map(src -> src.getPassword(), UserDTO::setPassword);
                    mapper.map(src -> src.getFirstName(), UserDTO::setFirstName);
                    mapper.map(src -> src.getLastName(), UserDTO::setLastName);
                    mapper.map(src -> src.getPhoneNumber(), UserDTO::setPhoneNumber);
                    mapper.map(src -> src.getIsactive(), UserDTO::setIsactive);
                    mapper.map(src -> src.getCreatedAt(), UserDTO::setCreatedAt);
                });

        return modelMapper;
    }
}