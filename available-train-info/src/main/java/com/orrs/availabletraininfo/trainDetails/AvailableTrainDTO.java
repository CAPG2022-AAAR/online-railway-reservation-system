package com.orrs.availabletraininfo.trainDetails;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class AvailableTrainDTO {
    private long source_id;
    private long destination_id;

    //TODO: change day to date and then get day from that date

    private String day;
}
