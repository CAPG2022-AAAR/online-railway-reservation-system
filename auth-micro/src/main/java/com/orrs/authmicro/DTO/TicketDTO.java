package com.orrs.authmicro.DTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor

public class TicketDTO {

    private String f_name;
    private String l_name;
    private String gender;
    private String address;
    private String email;
    private int seats;
    private int amount;
    private int age;
    private Long c_id;
    private Long train_number;
    private Long source_id;
    private Long destination_id;
    private int departure_time;
    private String date;

}
