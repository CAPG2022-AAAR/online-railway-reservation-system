package com.orrs.bookingservice.ticketDetails;

import javax.persistence.*;

@Entity
@Table(name="TicketDetails")
public class TicketDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)


    private String f_name;
    private String l_name;
    private String gender;
    private String address;
    private int seats;
    private int amount;
    private Long pnr;
    private int age;

    private Long train_number;

    public Long getTrain_number() {
        return train_number;
    }

    public void setTrain_number(Long train_number) {
        this.train_number = train_number;
    }

    public String getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(String depart_time) {
        this.depart_time = depart_time;
    }

    private String depart_time;







    public TicketDetails(String f_name, String l_name, String gender, String address, int seats, int amount, int age,Long train_number, String depart_time) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.gender = gender;
        this.address = address;
        this.seats = seats;
        this.amount = amount;

        this.age = age;
        this.train_number = train_number;
        this.depart_time = depart_time;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getPnr() {
        return pnr;
    }

    public void setPnr(Long pnr) {
        this.pnr = pnr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
