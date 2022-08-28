package com.orrs.availabletraininfo.trainService;

import com.orrs.availabletraininfo.trainDetails.AvailableTrainDTO;
import com.orrs.availabletraininfo.trainDetails.TrainRequest;
import com.orrs.availabletraininfo.trainDetails.Train_details;
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

}
