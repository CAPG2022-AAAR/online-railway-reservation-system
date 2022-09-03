package com.orrs.authmicro.controllers;


import com.orrs.authmicro.DTO.AvailableTrainDTO;
import com.orrs.authmicro.entity.AvailableTrains;
import com.orrs.authmicro.entity.ListOfTrainDetailsToReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/getavailabletrains")
public class TrainController {

    @Autowired
    private RestTemplate restTemplate;


    //we take two stations and date as input and get a list of trains along with their details from the train-details
    //microservice
    @GetMapping
    public String betweenCities(){
        return "Enter source and destination along with date ";
    }



    @PostMapping
    public ListOfTrainDetailsToReturn availableTrains(@RequestBody AvailableTrainDTO availableTrainDTO){

        ListOfTrainDetailsToReturn list = restTemplate
                .postForObject("http://localhost:8080/api/v1/get-train-details" ,
                        availableTrainDTO ,
                        ListOfTrainDetailsToReturn.class );

        return list;
    }


}
