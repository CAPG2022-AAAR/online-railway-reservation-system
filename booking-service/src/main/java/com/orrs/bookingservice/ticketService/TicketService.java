package com.orrs.bookingservice.ticketService;


import com.orrs.bookingservice.emailDetails.EmailDetails;
import com.orrs.bookingservice.ticketDetails.TicketDetails;
import com.orrs.bookingservice.ticketDetails.TicketRequest;
import com.orrs.bookingservice.ticketRepository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@AllArgsConstructor
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private JavaMailSender javaMailSender;

/*
    // getting all the ticket records by using the method findAll() of Crud Repository
    public List<TicketDetails> getAllTicketDetails() {

        List<TicketDetails> ticketDetails = new ArrayList<TicketDetails>();
        ticketRepository.findAll().forEach(ticketDetails1 -> ticketDetails.add(ticketDetails1));
        return ticketDetails;
    }
*/
    // saving a specific record by using the method save() of crud repository
    public TicketDetails saveTicketDetails(TicketRequest ticketDetails) {
        return ticketRepository.save(new TicketDetails(
                ticketDetails.getF_name(),
                ticketDetails.getL_name(),
                ticketDetails.getGender(),
                ticketDetails.getAddress(),
                ticketDetails.getSeats(),
                ticketDetails.getAmount(),
                ticketDetails.getC_id(),
                ticketDetails.getAge(),
                ticketDetails.getTrain_number(),
                ticketDetails.getSource_id(),
                ticketDetails.getDestination_id(),
                ticketDetails.getDeparture_time()
        ));
    }

    // deleting a specific record by using the method deleteById() of crud repository
    public void deleteTicketDetails(Long id) {
        ticketRepository.deleteById(id);

    }

    //updating the record
    public ResponseEntity<TicketDetails> updateTicketDetails(int id, TicketDetails ticketDetails) {
    return null;
    }

    // getting a specific record by using   the method findById() of crud repository
    public TicketDetails findById(long id) {
        return ticketRepository.findById(id).get();

    }


    @Value("${spring.mail.username}") private String sender;

    // Method 1
    // To send a simple email
    public String sendSimpleMail(EmailDetails details)
    {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    // Method 2
    // To send an email with attachment
    public String sendMailWithAttachment(EmailDetails details)
    {
        // Creating a mime message
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to

            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                    details.getSubject());

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }
}


