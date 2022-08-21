package com.orrs.availabletraininfo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor

public class Train {
    private Long t_id;
    private String t_name;
    private int t_coach;
    private int t_seat;
    private int t_fare;
    private int s_time;
    private int e_time;
}
