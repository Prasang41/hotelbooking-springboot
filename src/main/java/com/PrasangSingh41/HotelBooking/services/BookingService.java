package com.PrasangSingh41.HotelBooking.services;

import com.PrasangSingh41.HotelBooking.dtos.BookingDTO;
import com.PrasangSingh41.HotelBooking.dtos.Response;

public interface BookingService {

    Response getAllBookings();
    Response createBooking(BookingDTO bookingDTO);
    Response findBookingByReferenceNo(String  bookingReference);
    Response updateBooking(BookingDTO bookingDTO);
}
