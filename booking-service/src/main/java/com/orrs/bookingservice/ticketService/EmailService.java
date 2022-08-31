package com.orrs.bookingservice.ticketService;

import com.orrs.bookingservice.emailDetails.EmailDetails;

public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
