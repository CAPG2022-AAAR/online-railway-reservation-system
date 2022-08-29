package com.orrs.availabletraininfo.trainService;

import com.netflix.discovery.converters.Auto;
import com.orrs.availabletraininfo.repositories.StationRepository;
import com.orrs.availabletraininfo.repositories.TrainScheduleRepository;
import com.orrs.availabletraininfo.trainDetails.*;
import com.orrs.availabletraininfo.trainDetailsRepository.TrainDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainServices {

    @Autowired
    TrainDetailsRepository trainDetailsRepository;

    @Autowired
    StationRepository stationRepository;

    @Autowired
    TrainScheduleRepository trainScheduleRepository;

    // saving a specific record by using the method save() of crud repository
    public Train_details saveTrainDetails(TrainRequest train_details) {
        return trainDetailsRepository.save(new Train_details(
                train_details.getT_id(),
                train_details.getT_name(),
                train_details.getT_coach(),
                train_details.getT_seat(),
                train_details.getT_fare(),
                train_details.getS_time(),
                train_details.getE_time()
                ));
    }

    public List<Train_details> getTrainDetails(AvailableTrainDTO availableTrainDTO){
        return trainDetailsRepository.findAll();
    }

    public TrainDepartureDetails saveTrainDepartureDetails(TrainDepartureDetails trainDepartureDetails) {
        return null;

    }

    public StationDetails saveStationDetails(StationRequest stationDetails) {
        return stationRepository.save(new StationDetails(
                stationDetails.getStationId(),
                stationDetails.getStationName()
        ));
    }

    public TrainArrivalDetails saveTrainArrivalDetails(TrainArrivalDetails trainArrivalDetails) {
        return null;
    }

    public TrainSchedule saveTrainSchedule(TrainScheduleRequest trainSchedule) {
        return trainScheduleRepository.save(new TrainSchedule(
                trainSchedule.getT_id(),
                trainSchedule.isMonday(),
                trainSchedule.isTuesday(),
                trainSchedule.isWednesday(),
                trainSchedule.isThursday(),
                trainSchedule.isFriday(),
                trainSchedule.isSaturday(),
                trainSchedule.isSunday()
        ));
    }
}
