package com.orrs.bookingservice.emailDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetail {

    private String recipient;
    private String messageBody;
    private String subject;
}
