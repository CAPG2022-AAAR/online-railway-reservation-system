package com.orrs.bookingservice.messageQueue;

import com.orrs.bookingservice.emailDetail.EmailDetail;
import com.orrs.bookingservice.emailDetail.EmailServiceImplementation;
import com.orrs.bookingservice.ticketDetails.PaymentStatus;
import com.orrs.bookingservice.ticketDetails.TicketDetails;
import com.orrs.bookingservice.ticketRepository.TicketRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MessageListener {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EmailServiceImplementation emailServiceImplementation;

    @RabbitListener(queues = MQConfig.TICKETQ)
    public void listener(TicketSuccessMessage message){

        String msg = message.getMessage();
        char firstChar = msg.charAt(0);


        String strPnr = message.getMessage().substring(1);
        long pnr = Long.parseLong(strPnr);

        TicketDetails ticket = new TicketDetails();

        Optional<TicketDetails>  opTicket =  ticketRepository.findById(pnr);
        if(opTicket.isPresent()){


            ticket = opTicket.get();

            if(firstChar == 's'){


                ticket.setPaymentStatus(PaymentStatus.SUCCESS);
                ticketRepository.save(ticket);

                System.out.println(ticket.toString());

                String Message = "Your PNR for train ticket is : " + ticket.getPnr() + "\r\n"
                        + "seats: "+ ticket.getSeats()+ "\r\n"
                        + "Fare: "+ ticket.getAmount()+ "\r\n"
                        + "Date: "+ ticket.getDate();




                EmailDetail emailDetail = new EmailDetail();
                emailDetail.setMessageBody(Message);
                emailDetail.setRecipient(ticket.getEmail());
                emailDetail.setSubject("PNR for ticket");


                String emailResponse = emailServiceImplementation.sendSimpleMail(emailDetail);



            }else{


                ticketRepository.deleteById(pnr);

                String Message = "Payment for ticket PNR: "+ticket.getPnr()+" Failed!";

                EmailDetail emailDetail = new EmailDetail();
                emailDetail.setMessageBody(Message);
                emailDetail.setRecipient(ticket.getEmail());
                emailDetail.setSubject("PNR for ticket");


                String emailResponse = emailServiceImplementation.sendSimpleMail(emailDetail);
            }

        }else{
            System.out.println("Such Ticket doesnt exist");
        }


        System.out.println(message);


    }
}
