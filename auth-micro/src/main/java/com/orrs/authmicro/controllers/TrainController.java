package com.orrs.authmicro.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/traindetails")
public class TrainController {


    //we take two stations and date as input and get a list of trains along with their details from the train-details
    //microservice
    @GetMapping(value = "/betweenstations")
    public String betweenCities(){
        return "Enter source and destination along with date ";
    }


    //After taking the cities we return the output list through this route
    @PostMapping("/betweenstations")
    public String availableTrains(){
        //get details from train-details microsevice in form of List<Train>
        return "These are available trains for the entered stations and date";
    }


}
