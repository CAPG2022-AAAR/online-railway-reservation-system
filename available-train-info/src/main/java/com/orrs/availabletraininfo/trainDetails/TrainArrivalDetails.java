package com.orrs.availabletraininfo.trainDetails;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "train_arrival_details")
public class TrainArrivalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long e_id;

    private long stationId;
    private long trainId;
    private long arrivalTime;

    public TrainArrivalDetails(long stationId, long trainId, long arrivalTime) {
       this.stationId = stationId;
        this.trainId = trainId;
        this.arrivalTime = arrivalTime;
    }
}
