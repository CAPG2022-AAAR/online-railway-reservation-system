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
@Table(name = "station_details")
public class StationDetails {

    @Id
    private long StationId; //primary key
    private String StationName;

    public StationDetails(long stationId, String stationName) {
        StationId = stationId;
        StationName = stationName;
    }
}
