package com.orrs.authmicro.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


public class AvailableTrains {
    private List<Long> trainList = new ArrayList<>();

    public List<Long> getTrainList() {
        return trainList;
    }
}
