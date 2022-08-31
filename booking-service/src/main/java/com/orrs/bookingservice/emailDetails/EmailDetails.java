package com.orrs.bookingservice.emailDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class EmailDetails {

    private String recipient;
    private String msgBody;
    private String subject;
}
