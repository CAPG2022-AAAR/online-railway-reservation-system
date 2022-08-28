package com.orrs.availabletraininfo.controller;


import com.orrs.availabletraininfo.trainDetails.AvailableTrainDTO;
import com.orrs.availabletraininfo.trainDetails.TrainRequest;
import com.orrs.availabletraininfo.trainDetails.Train_details;
import com.orrs.availabletraininfo.trainService.TrainServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/train_details")
public class TrainDetailsController {

    @Autowired
    private TrainServices trainServices;

    @GetMapping
    public String getMessage() {
        return "welcome to online railway reservation system for train details ";
    }

    // creating a post mapping that will post the train details in the database
    @PostMapping("/create")
    private Long saveTrainDetails(@RequestBody TrainRequest trainRequest) {
        return trainServices.saveTrainDetails(trainRequest).getT_id();

    }

    @PostMapping("/traindetails")
    private List<Train_details> trainDetails(@RequestBody AvailableTrainDTO availableTrainDTO){

        return trainServices.getTrainDetails(availableTrainDTO);

    }


}
