package com.orrs.bookingservice.ticketService;


import com.orrs.bookingservice.emailDetails.EmailDetails;
import com.orrs.bookingservice.emailDetails.EmailServiceImp;
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
    private EmailServiceImp emailServiceImp;


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

        TicketDetails createdTicket = ticketRepository.save(new TicketDetails(
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


        String Message = "Your Ticket details are" + createdTicket.getPnr();


        EmailDetails details = new EmailDetails();
        details.setMsgBody(Message);
        details.setRecipient("anu10300@gmail.com");
        details.setSubject("");

        String emailResponse;

        if (createdTicket != null) {
            emailResponse = emailServiceImp.sendSimpleMail(details);
        }
        return createdTicket;
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

}


