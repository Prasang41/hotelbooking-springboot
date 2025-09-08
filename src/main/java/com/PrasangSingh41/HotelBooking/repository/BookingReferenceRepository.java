package com.PrasangSingh41.HotelBooking.repository;

import com.PrasangSingh41.HotelBooking.entities.BookingReference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingReferenceRepository extends JpaRepository<BookingReference, Long> {
    Optional<BookingReference> findByReferenceNo(String referenceNo);
}
