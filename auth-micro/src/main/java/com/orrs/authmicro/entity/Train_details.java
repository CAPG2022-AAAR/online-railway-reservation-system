package com.orrs.authmicro.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor

public class Train_details {

    private Long t_id;
    private String t_name;
    private int t_coach;
    private int t_seat;
    private int t_fare;
    private int s_time;
    private int e_time;

    public Train_details(Long t_id, String t_name, int t_coach, int t_seat, int t_fare, int s_time, int e_time) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_coach = t_coach;
        this.t_seat = t_seat;
        this.t_fare = t_fare;
        this.s_time = s_time;
        this.e_time = e_time;
    }
}