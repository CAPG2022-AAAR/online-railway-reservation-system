package com.orrs.availabletraininfo.trainDetails;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "train_departure_details")
public class TrainDepartureDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long e_id;
    private long stationId; //primary key
    private long trainId;
    private long departureTime;

    public TrainDepartureDetails(long stationId, long trainId, long departureTime) {
        this.stationId = stationId;
        this.trainId = trainId;
        this.departureTime = departureTime;
    }
}
