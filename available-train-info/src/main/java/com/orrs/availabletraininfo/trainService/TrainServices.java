package com.orrs.availabletraininfo.trainService;

import com.orrs.availabletraininfo.repositories.*;
import com.orrs.availabletraininfo.trainDetails.*;
import com.orrs.availabletraininfo.trainDetailsRepository.TrainDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    DayOfTheWeek dayOfTheWeek;

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

    public ListOfTrainDetailsToReturn getTrainDetails(AvailableTrainDTO availableTrainDTO) throws Exception {



        List<TrainDetailsToReturn> finalTrainDetails = new ArrayList<>();
        ListOfTrainDetailsToReturn listOfTrainDetailsToReturn = new ListOfTrainDetailsToReturn();
        TrainDetailsToReturn trainDetailsToReturn = new TrainDetailsToReturn();
        List<TrainSchedule> listOfAvailableTrainsOnADay;
        List<Long> listOfTrainNumbers = new ArrayList<>();
        List<Long> listOfTrainNumbersRunningOnADay = new ArrayList<>();
        List<TrainArrivalDetails> trainArrivalDetails = trainArrivalRepository.findAll();
        String sourceName = stationRepository.findById(availableTrainDTO.getSource_id()).get().getStationName();
        String destinationName = stationRepository.findById(availableTrainDTO.getDestination_id()).get().getStationName();

        String day = new String();

        try{
            day = dayOfTheWeek.convertDayToDate(availableTrainDTO.getDate());
        }catch (ParseException parseEx) {
            parseEx.printStackTrace();
        }



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
            int sourceStopNumber = 0 ;
            int destinationStopNumber = 0 ;
            boolean sourceFound = false;
            boolean destinationFound = false;

            for( int j = 0 ; j<trainArrivalDetails.size() ; j++ ){

                if(trainArrivalDetails.get(j).getTrainId() == tempTrainNumber) {

                    if( availableTrainDTO.getSource_id() == trainArrivalDetails.get(j).getStationId()) {

                        sourceStopNumber = trainArrivalDetails.get(j).getStopNumber();
                        sourceFound = true;

                    }
                    if(trainArrivalDetails.get(j).getStationId() == availableTrainDTO.getDestination_id()) {
                        destinationStopNumber = trainArrivalDetails.get(j).getStopNumber();
                        destinationFound = true;
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
        for(int i = 0 ; i < listOfTrainNumbersRunningOnADay.size() ; i++){
            long trainId = listOfTrainNumbersRunningOnADay.get(i);
            trainDetailsToReturn.setSource(sourceName);
            trainDetailsToReturn.setDestination(destinationName);
            trainDetailsToReturn.setTrainId(trainId);
            trainDetailsToReturn.setTrainName(trainDetailsRepository.findById(trainId).get().getT_name());
            trainDetailsToReturn.setFare(trainDetailsRepository.findById(trainId).get().getT_fare());

            trainDetailsToReturn.setSourceDepartureTime(getStationDepartureTime(availableTrainDTO.getSource_id(),trainId));
            trainDetailsToReturn.setDestinationArrivalTime(getStationArrivalTime(availableTrainDTO.getDestination_id(), trainId));

            finalTrainDetails.add(trainDetailsToReturn);
        }
        listOfTrainDetailsToReturn.setList(finalTrainDetails);

        return listOfTrainDetailsToReturn;
    }

    public TrainDepartureDetails saveTrainDepartureDetails(TrainDepartureRequest trainDepartureDetails) {
        return trainDepartureRepository.save(new TrainDepartureDetails(
                trainDepartureDetails.getStationId(),
                trainDepartureDetails.getTrainId(),
                trainDepartureDetails.getDepartureTime()
        ));

    }

    public int getStationArrivalTime(long stationId , long trainId){
        List<TrainArrivalDetails> trainArrivalDetails = trainArrivalRepository.findAll();
        int time = 0;
        for(int j = 0 ; j < trainArrivalDetails.size() ; j++){

            if(trainArrivalDetails.get(j).getStationId()==stationId && trainArrivalDetails.get(j).getTrainId()==trainId){
                time = (int)trainArrivalDetails.get(j).getArrivalTime();
                break;
            }

        }
        return time;
    }

    public int getStationDepartureTime(long stationId , long trainId){
        List<TrainArrivalDetails> trainArrivalDetails = trainArrivalRepository.findAll();
        int time = 0;
        for(int j = 0 ; j < trainArrivalDetails.size() ; j++){

            if(trainArrivalDetails.get(j).getStationId()==stationId && trainArrivalDetails.get(j).getTrainId()==trainId){
                time = (int)trainArrivalDetails.get(j).getDepartureTime();
                break;
            }

        }
        return time;
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


    public Seats saveSeatDetails(SeatDTO seatDTO){

        Seats seats = new Seats(
                seatDTO.getT_id(),
                seatDTO.getMonday(),
                seatDTO.getTuesday(),
                seatDTO.getWednesday(),
                seatDTO.getThursday(),
                seatDTO.getFriday(),
                seatDTO.getSaturday(),
                seatDTO.getSunday()
        );
        return seatRepository.save(seats);

    }


    public Seats getSeatDetails(Long trainId){
        Optional<Seats> seats = seatRepository.findById(trainId);
        return seats.get();
    }

    public int getAvailableSeats(long trainId , String date){

        String day = new String();
        Optional<Seats> optionalSeats = seatRepository.findById(trainId);
        Seats seats = optionalSeats.get();
        int availableSeats = 0;


        try{
            day = dayOfTheWeek.convertDayToDate(date);
        }catch (ParseException parseEx) {
            parseEx.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        switch (day){
            case "Monday":
                availableSeats = seats.getMonday();
            break;
            case "Tuesday":
                availableSeats = seats.getTuesday();
                break;
            case "Wednesday":
                availableSeats = seats.getWednesday();
                break;
            case "Thursday":
                availableSeats = seats.getThursday();
                break;
            case "Friday":
                availableSeats = seats.getFriday();
                break;
            case "Saturday":
                availableSeats = seats.getSaturday();
                break;
            case "Sunday":
                availableSeats = seats.getSunday();
                break;
        }
        return availableSeats;
    }
}
