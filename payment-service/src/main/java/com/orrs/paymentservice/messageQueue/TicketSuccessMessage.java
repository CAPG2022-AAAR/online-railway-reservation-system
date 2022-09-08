package com.orrs.paymentservice.messageQueue;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketSuccessMessage {


    private String messageId;
    private String message;
    private Date messageDate;
}
