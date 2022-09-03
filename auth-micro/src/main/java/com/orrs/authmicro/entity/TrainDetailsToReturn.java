package com.orrs.authmicro.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TrainDetailsToReturn {
    private long trainId;
    private String trainName;
    private String source;
    private int sourceDepartureTime;
    private String destination;
    private int destinationArrivalTime;
    private int fare;
}
