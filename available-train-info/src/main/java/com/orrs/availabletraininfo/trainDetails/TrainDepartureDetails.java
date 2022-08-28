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
@Table(name = "train_departure_details")
public class TrainDepartureDetails {

    @Id
    private long StationId; //primary key
    private long TrainId;
    private long DepartureTime;

    public TrainDepartureDetails(long stationId, long trainId, long departureTime) {
        StationId = stationId;
        TrainId = trainId;
        DepartureTime = departureTime;
    }
}
