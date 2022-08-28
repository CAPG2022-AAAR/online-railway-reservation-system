package com.orrs.availabletraininfo.trainDetails;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class TrainRequest {
    private long t_id;
    private String t_name;
    private int t_coach;
    private int t_seat;
    private int t_fare;
    private int s_time;
    private int e_time;
}
