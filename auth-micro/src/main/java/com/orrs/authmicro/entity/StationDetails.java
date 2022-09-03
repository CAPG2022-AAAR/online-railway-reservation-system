package com.orrs.authmicro.entity;


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
public class StationDetails {


    private long StationId;
    private String StationName;

    public StationDetails(long stationId, String stationName) {
        this.StationId = stationId;
        this.StationName = stationName;
    }
}
