package com.PrasangSingh41.HotelBooking.notifications;

import com.PrasangSingh41.HotelBooking.dtos.NotificationDTO;;

public interface NotificationService
{
    void sendEmail(NotificationDTO notificationDTO);
    void sendSMS();
    void sendWhatsApp();


}
