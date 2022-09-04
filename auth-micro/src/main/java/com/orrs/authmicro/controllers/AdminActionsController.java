package com.orrs.authmicro.controllers;


import com.orrs.authmicro.DTO.StationRequest;
import com.orrs.authmicro.DTO.TrainArrivalRequest;
import com.orrs.authmicro.DTO.TrainRequest;
import com.orrs.authmicro.DTO.TrainScheduleRequest;
import com.orrs.authmicro.entity.StationDetails;
import com.orrs.authmicro.entity.TrainArrivalDetails;
import com.orrs.authmicro.entity.TrainSchedule;
import com.orrs.authmicro.entity.Train_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/admin")
public class AdminActionsController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/check-connection")
    public String checkConnection(){
        String str = restTemplate.getForObject("http://AVAILABLE-TRAIN-INFO-SERVICE/api/v1/trains/return-string",String.class);
        return str;
    }

    @PostMapping("/create-train")
    public Train_details saveTrain(@RequestBody TrainRequest trainRequest){

        Train_details createdTrain = restTemplate
                .postForObject("http://AVAILABLE-TRAIN-INFO-SERVICE/api/v1/save-train-details", trainRequest , Train_details.class);
        return createdTrain;

    }

    @PostMapping("/create-station")
    public StationDetails saveStation(@RequestBody StationRequest stationRequest){

        StationDetails createdStation = restTemplate
                .postForObject("http://AVAILABLE-TRAIN-INFO-SERVICE/api/v1/save-station-details",stationRequest,StationDetails.class);
        return createdStation;
    }

    @PostMapping("/create-train-schedule")
    public TrainSchedule saveTrainSchedule(@RequestBody TrainScheduleRequest trainScheduleRequest){
        TrainSchedule createdSchedule = restTemplate
                .postForObject("http://AVAILABLE-TRAIN-INFO-SERVICE/api/v1/save-train-schedule",trainScheduleRequest,TrainSchedule.class);
        return createdSchedule;
    }


    @PostMapping("/create-train-arrival-details")
    public TrainArrivalDetails saveTrainArrivalDetails(@RequestBody TrainArrivalRequest trainArrivalRequest){
        TrainArrivalDetails createdTrainArrivalDetails = restTemplate
                .postForObject("http://localhost:8080/api/v1/save-train-arrival-details",trainArrivalRequest , TrainArrivalDetails.class);

        return createdTrainArrivalDetails;
    }
}
