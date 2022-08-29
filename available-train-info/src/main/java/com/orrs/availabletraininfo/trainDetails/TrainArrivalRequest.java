package com.orrs.availabletraininfo.trainDetails;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TrainArrivalRequest {

    private long stationId;
    private long trainId;
    private long arrivalTime;
    private long departureTime;
    private int stopNumber;
}
