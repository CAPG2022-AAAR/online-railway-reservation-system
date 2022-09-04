package com.orrs.authmicro.DTO;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class AvailableTrainDTO {
    private String source_id;
    private String destination_id;
    private String date;
}
