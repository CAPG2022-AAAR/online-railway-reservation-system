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
    private String date;
}
