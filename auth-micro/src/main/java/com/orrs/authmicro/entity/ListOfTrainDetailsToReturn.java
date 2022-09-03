package com.orrs.authmicro.entity;

import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListOfTrainDetailsToReturn {
    List<TrainDetailsToReturn> list;

    public void setList(List<TrainDetailsToReturn> list) {
        this.list = list;
    }

}
