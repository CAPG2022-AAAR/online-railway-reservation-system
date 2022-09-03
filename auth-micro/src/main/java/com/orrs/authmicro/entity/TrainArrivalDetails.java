package com.orrs.authmicro.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor

public class TrainArrivalDetails {


    private long e_id;

    private long stationId;
    private long trainId;
    private long arrivalTime;

    private long departureTime;

    private int stopNumber;

    public TrainArrivalDetails(long stationId, long trainId, long arrivalTime , long departureTime, int stopNumber) {
       this.stationId = stationId;
        this.trainId = trainId;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stopNumber = stopNumber;
    }
}
