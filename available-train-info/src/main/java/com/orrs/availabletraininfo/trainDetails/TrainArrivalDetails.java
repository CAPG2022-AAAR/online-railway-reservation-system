package com.orrs.availabletraininfo.trainDetails;


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
@Entity
@Table(name = "train_arrival_details")
public class TrainArrivalDetails {

    @Id
    private long StationId; //primary key
    private long TrainId;
    private long ArrivalTime;

    public TrainArrivalDetails(long stationId, long trainId, long arrivalTime) {
        StationId = stationId;
        TrainId = trainId;
        ArrivalTime = arrivalTime;
    }
}
