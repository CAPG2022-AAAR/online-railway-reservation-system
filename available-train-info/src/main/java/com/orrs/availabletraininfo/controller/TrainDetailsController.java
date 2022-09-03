package com.orrs.availabletraininfo.controller;


import com.orrs.availabletraininfo.trainDetails.*;
import com.orrs.availabletraininfo.trainService.TrainServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class TrainDetailsController {

    @Autowired
    private TrainServices trainServices;

    @GetMapping
    public String getMessage() {
        return "welcome to online railway reservation system for train details ";
    }

    // creating a post mapping that will post the train details in the database
    @PostMapping("/save-train-details")
    private Long saveTrainDetails(@RequestBody TrainRequest trainRequest) {
        return trainServices.saveTrainDetails(trainRequest).getT_id();

    }

    @PostMapping("get-train-details")
    public ListOfTrainDetailsToReturn trainDetails(@RequestBody AvailableTrainDTO availableTrainDTO) throws Exception {

       return trainServices.getTrainDetails(availableTrainDTO);
    }

    @PostMapping("/save-station-details")
    public  StationDetails saveStationDetails(@RequestBody StationRequest stationDetails) {
        return  trainServices.saveStationDetails(stationDetails);
    }

    @PostMapping("/save-train-arrival-details")
    public TrainArrivalDetails saveTrainArrivalDetails(@RequestBody TrainArrivalRequest trainArrivalRequest) {
        return  trainServices.saveTrainArrivalDetails(trainArrivalRequest);
    }

    @PostMapping("/save-train-departure-details")
    public TrainDepartureDetails saveTrainDepartureDetails(@RequestBody TrainDepartureRequest trainDepartureRequest) {
        return  trainServices.saveTrainDepartureDetails(trainDepartureRequest);
    }

    @PostMapping("/save-train-schedule")
    private TrainSchedule saveTrainSchedule(@RequestBody TrainScheduleRequest trainSchedule) {
        return  trainServices.saveTrainSchedule(trainSchedule);
    }


}
