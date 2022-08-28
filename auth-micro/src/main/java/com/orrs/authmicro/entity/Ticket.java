package com.orrs.authmicro.entity;

import com.orrs.authmicro.customer.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private long pnr;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private String address;
    private int seats;
    private int amount;

}
