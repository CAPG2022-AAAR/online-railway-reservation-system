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

    //TODO: change day to date and then get day from that date

    private String day;
}
