package com.orrs.availabletraininfo.trainDetails;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TrainDepartureRequest {
    private long stationId;
    private long trainId;
    private long departureTime;
}
