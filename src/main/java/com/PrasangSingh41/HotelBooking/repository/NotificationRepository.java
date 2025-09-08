package com.PrasangSingh41.HotelBooking.repository;

import com.PrasangSingh41.HotelBooking.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
