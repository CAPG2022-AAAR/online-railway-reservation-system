package com.orrs.authmicro.DTO;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class AvailableTrainDTO {
    private String source;
    private String destination;
    private String date;
}
