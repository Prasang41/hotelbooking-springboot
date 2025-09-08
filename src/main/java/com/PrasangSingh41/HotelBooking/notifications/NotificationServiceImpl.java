package com.PrasangSingh41.HotelBooking.notifications;

import com.PrasangSingh41.HotelBooking.entities.Notification;
import com.PrasangSingh41.HotelBooking.dtos.NotificationDTO;
import com.PrasangSingh41.HotelBooking.enums.NotificationType;
import com.PrasangSingh41.HotelBooking.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
private final JavaMailSender javaMailSender;
private  final NotificationRepository notificationRepository;
    @Override
    @Async
    public void sendEmail(NotificationDTO notificationDTO) {
      log.info("Sending Email");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(notificationDTO.getRecipient());
        simpleMailMessage.setSubject(notificationDTO.getSubject());
        simpleMailMessage.setText(notificationDTO.getBody());

        javaMailSender.send(simpleMailMessage);//sending email

        //Database save
        Notification notificationToSave = Notification.builder().
                recipient(notificationDTO.getRecipient())
                .subject(notificationDTO.getSubject())
                .body(notificationDTO.getBody())
                .bookingReference(notificationDTO.getBookingReference())
                .type(NotificationType.EMAIL)
                .build();
        notificationRepository.save(notificationToSave);
    }

    @Override
    public void sendSMS() {

    }

    @Override
    public void sendWhatsApp() {

    }
}
