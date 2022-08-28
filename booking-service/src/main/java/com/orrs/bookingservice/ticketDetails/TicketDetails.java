package com.orrs.bookingservice.ticketDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ticket_details")
public class TicketDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long pnr;    //primary key
    private String f_name;
    private String l_name;
    private String gender;
    private String address;
    private int seats;
    private int amount;
    private Long c_id;
    private int age;
    private Long train_number;
    private Long source_id;
    private Long destination_id;
    private int departure_time;

    public TicketDetails(String f_name, String l_name, String gender, String address, int seats, int amount, Long c_id, int age, Long train_number,Long source_id, Long destination_id, int departure_time) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.gender = gender;
        this.address = address;
        this.seats = seats;
        this.amount = amount;
        this.c_id = c_id;
        this.age = age;
        this.train_number = train_number;
        this.source_id = source_id;
        this.destination_id = destination_id;
        this.departure_time = departure_time;
        }


}

