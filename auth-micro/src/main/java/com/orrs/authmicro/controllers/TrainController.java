package com.orrs.authmicro.controllers;


import com.orrs.authmicro.DTO.AvailableTrainDTO;
import com.orrs.authmicro.entity.AvailableTrains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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


    //After taking the cities we return the output list through this route
    @PostMapping
    public AvailableTrains availableTrains(@RequestBody AvailableTrainDTO availableTrainDTO){

        //get details from train-details microsevice in form of List<Train>
        AvailableTrains list = new AvailableTrains();
        list = restTemplate.postForObject("http://localhost:8080/" ,  availableTrainDTO , AvailableTrains.class );
        return list;
    }


}
