package com.orrs.paymentservice.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
    private long pnr;

}
