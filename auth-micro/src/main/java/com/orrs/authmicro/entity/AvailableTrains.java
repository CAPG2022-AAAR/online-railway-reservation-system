package com.orrs.authmicro.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class AvailableTrains {
    List<Train> trainList;
}
