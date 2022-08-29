package com.orrs.availabletraininfo.trainService;

import com.orrs.availabletraininfo.repositories.StationRepository;
import com.orrs.availabletraininfo.repositories.TrainArrivalRepository;
import com.orrs.availabletraininfo.repositories.TrainDepartureRepository;
import com.orrs.availabletraininfo.repositories.TrainScheduleRepository;
import com.orrs.availabletraininfo.trainDetails.*;
import com.orrs.availabletraininfo.trainDetailsRepository.TrainDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    TrainArrivalRepository trainArrivalRepository;

    @Autowired
    TrainDepartureRepository trainDepartureRepository;

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

    public List<Long> getTrainDetails(AvailableTrainDTO availableTrainDTO){

        List<Train_details> temp;
        List<TrainSchedule> listOfAvailableTrainsOnADay;
        List<Long> listOfTrainNumbers = new ArrayList<>();
        List<Long> listOfTrainNumbersRunningOnADay = new ArrayList<>();
        List<TrainArrivalDetails> trainArrivalDetails = trainArrivalRepository.findAll();


        String day = availableTrainDTO.getDay();

        switch(day) {
            case "Monday":

              listOfAvailableTrainsOnADay =   trainScheduleRepository.findAll();
                for( int i = 0 ; i<listOfAvailableTrainsOnADay.size() ; i++  ){
                    if(listOfAvailableTrainsOnADay.get(i).isMonday()){
                        listOfTrainNumbers.add(listOfAvailableTrainsOnADay.get(i).getT_id());
                    }
                }
                break;
            case "Tuesday":

                listOfAvailableTrainsOnADay =   trainScheduleRepository.findAll();
                for( int i = 0 ; i<listOfAvailableTrainsOnADay.size() ; i++  ){
                    if(listOfAvailableTrainsOnADay.get(i).isTuesday()){
                        listOfTrainNumbers.add(listOfAvailableTrainsOnADay.get(i).getT_id());
                    }
                }


                break;
            case "Wednesday":

                listOfAvailableTrainsOnADay =   trainScheduleRepository.findAll();
                for( int i = 0 ; i<listOfAvailableTrainsOnADay.size() ; i++  ){
                    if(listOfAvailableTrainsOnADay.get(i).isWednesday()){
                        listOfTrainNumbers.add(listOfAvailableTrainsOnADay.get(i).getT_id());
                    }
                }

                break;
            case "Thursday":

                listOfAvailableTrainsOnADay =   trainScheduleRepository.findAll();
                for( int i = 0 ; i<listOfAvailableTrainsOnADay.size() ; i++  ){
                    if(listOfAvailableTrainsOnADay.get(i).isThursday()){
                        listOfTrainNumbers.add(listOfAvailableTrainsOnADay.get(i).getT_id());
                    }
                }

                break;
            case "Friday":

                listOfAvailableTrainsOnADay =   trainScheduleRepository.findAll();
                for( int i = 0 ; i<listOfAvailableTrainsOnADay.size() ; i++  ){
                    if(listOfAvailableTrainsOnADay.get(i).isFriday()){
                        listOfTrainNumbers.add(listOfAvailableTrainsOnADay.get(i).getT_id());
                    }
                }

                break;
            case "Saturday":

                listOfAvailableTrainsOnADay =   trainScheduleRepository.findAll();
                for( int i = 0 ; i<listOfAvailableTrainsOnADay.size() ; i++  ){
                    if(listOfAvailableTrainsOnADay.get(i).isSaturday()){
                        listOfTrainNumbers.add(listOfAvailableTrainsOnADay.get(i).getT_id());
                    }
                }

                break;
            case "Sunday":

                listOfAvailableTrainsOnADay =   trainScheduleRepository.findAll();
                for( int i = 0 ; i<listOfAvailableTrainsOnADay.size() ; i++  ){
                    if(listOfAvailableTrainsOnADay.get(i).isSunday()){
                        listOfTrainNumbers.add(listOfAvailableTrainsOnADay.get(i).getT_id());
                    }
                }

                break;
            default:
                throw new IllegalStateException("Please enter a valid day");
        }

        for( int i  = 0 ; i < listOfTrainNumbers.size() ; i++){

            long tempTrainNumber = listOfTrainNumbers.get(i);
            System.out.println(tempTrainNumber);
            int sourceStopNumber = 0 ;
            int destinationStopNumber = 0 ;
            boolean sourceFound = false;
            boolean destinationFound = false;

            for( int j = 0 ; j<trainArrivalDetails.size() ; j++ ){

                if(trainArrivalDetails.get(j).getTrainId() == tempTrainNumber) {

                    System.out.println(trainArrivalDetails.get(j).getStationId());
                    System.out.println(availableTrainDTO.getSource_id());
                    if( availableTrainDTO.getSource_id() == trainArrivalDetails.get(j).getStationId()) {
                        System.out.println("Inside source matching if statement");
                        sourceStopNumber = trainArrivalDetails.get(j).getStopNumber();
                        sourceFound = true;
                        System.out.println("Source found! ");
                    }
                    if(trainArrivalDetails.get(j).getStationId() == availableTrainDTO.getDestination_id()) {
                        destinationStopNumber = trainArrivalDetails.get(j).getStopNumber();
                        destinationFound = true;
                        System.out.println("Destination found! ");
                    }

                    if(sourceFound && destinationFound){
                        if(sourceStopNumber < destinationStopNumber){
                            listOfTrainNumbersRunningOnADay.add(tempTrainNumber);
                            sourceFound = false;
                            destinationFound = false;
                        }
                    }
                }
            }

        }


        return listOfTrainNumbersRunningOnADay;
    }

    public TrainDepartureDetails saveTrainDepartureDetails(TrainDepartureRequest trainDepartureDetails) {
        return trainDepartureRepository.save(new TrainDepartureDetails(
                trainDepartureDetails.getStationId(),
                trainDepartureDetails.getTrainId(),
                trainDepartureDetails.getDepartureTime()
        ));

    }

    public StationDetails saveStationDetails(StationRequest stationDetails) {
        return stationRepository.save(new StationDetails(
                stationDetails.getStationId(),
                stationDetails.getStationName()
        ));
    }

    public TrainArrivalDetails saveTrainArrivalDetails(TrainArrivalRequest trainArrivalRequest) {



        return trainArrivalRepository.save(new TrainArrivalDetails(
             trainArrivalRequest.getStationId(),
                trainArrivalRequest.getTrainId(),
                trainArrivalRequest.getArrivalTime(),
                trainArrivalRequest.getDepartureTime(),
                trainArrivalRequest.getStopNumber()
        ));
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
