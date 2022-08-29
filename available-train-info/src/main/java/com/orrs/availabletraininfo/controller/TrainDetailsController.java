package com.orrs.availabletraininfo.controller;


import com.orrs.availabletraininfo.trainDetails.*;
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
    private List<Long> trainDetails(@RequestBody AvailableTrainDTO availableTrainDTO){
        return trainServices.getTrainDetails(availableTrainDTO);
    }

    @PostMapping("/stationdetails")
    private  StationDetails saveStationDetails(@RequestBody StationRequest stationDetails) {
        return  trainServices.saveStationDetails(stationDetails);
    }

    @PostMapping("/trainarrivaldetails")
    private TrainArrivalDetails saveTrainArrivalDetails(@RequestBody TrainArrivalRequest trainArrivalRequest) {
        return  trainServices.saveTrainArrivalDetails(trainArrivalRequest);
    }

    @PostMapping("/traindeparturedetails")
    private TrainDepartureDetails saveTrainDepartureDetails(@RequestBody TrainDepartureRequest trainDepartureRequest) {
        return  trainServices.saveTrainDepartureDetails(trainDepartureRequest);
    }

    @PostMapping("/trainschedule")
    private TrainSchedule saveTrainSchedule(@RequestBody TrainScheduleRequest trainSchedule) {
        return  trainServices.saveTrainSchedule(trainSchedule);
    }


}
