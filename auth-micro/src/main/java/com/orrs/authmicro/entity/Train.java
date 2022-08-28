package com.orrs.authmicro.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Train {

    private long trainId;
    private String trainName;
    private int totalCoaches;
    private int totalSeats;
    private int seatAvailable;
    private int trainFare;
    private int startTime;
    private int endTime;
}
