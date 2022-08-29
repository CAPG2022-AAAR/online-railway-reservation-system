package com.orrs.availabletraininfo.trainDetails;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TrainArrivalRequest {

    private long StationId;
    private long TrainId;
    private long ArrivalTime;
}
