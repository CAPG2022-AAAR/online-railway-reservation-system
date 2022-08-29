package com.orrs.availabletraininfo;

import com.orrs.availabletraininfo.repositories.StationRepository;
import com.orrs.availabletraininfo.repositories.TrainArrivalRepository;
import com.orrs.availabletraininfo.repositories.TrainDepartureRepository;
import com.orrs.availabletraininfo.repositories.TrainScheduleRepository;
import com.orrs.availabletraininfo.trainDetails.*;
import com.orrs.availabletraininfo.trainDetailsRepository.TrainDetailsRepository;
import com.orrs.availabletraininfo.trainService.TrainServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class AvailableTrainInfoApplicationTests {


	@Autowired
	private TrainServices trainServices;

	@MockBean
	private TrainDetailsRepository trainDetailsRepository;

	@MockBean
	private TrainScheduleRepository trainScheduleRepository;

	@MockBean
	private StationRepository stationRepository;

	@MockBean
	private TrainArrivalRepository trainArrivalRepository;

	@MockBean
	private TrainDepartureRepository trainDepartureRepository;

	@Test
	void saveTrain_details() {

		Train_details train_details = new Train_details(
				12345L,
				"Shatabdi exp",
				8,
				600,
				2000,
				1,
				2);

		TrainRequest trainRequest = new TrainRequest(
				12345L,
				"Shatabdi exp",
				8,
				600,
				2000,
				1,
				2);



		when(trainDetailsRepository.save(train_details)).thenReturn(train_details);
		assertEquals(12345,trainServices.saveTrainDetails(trainRequest).getT_id());
	}

	@Test
	void testSaveTrainSchedule() {

		TrainSchedule trainSchedule = new TrainSchedule(
				23456,
				true,
				true,
				false,
				true,
				true,
				false,
				true);

		TrainScheduleRequest trainScheduleRequest = new TrainScheduleRequest(
				23456,
				true,
				true,
				false,
				true,
				true,
				false,
				true);

		when(trainScheduleRepository.save(trainSchedule)).thenReturn(trainSchedule);
		assertEquals(23456,trainServices.saveTrainSchedule(trainScheduleRequest).getT_id());
	}

	@Test
	void testStationDetails() {

		StationDetails stationDetails = new StationDetails(
				67893,
				"Delhi");

		StationRequest stationRequest = new StationRequest(
				67893,
				"Delhi");

		when(stationRepository.save(stationDetails)).thenReturn(stationDetails);
		assertEquals(67893,trainServices.saveStationDetails(stationRequest).getStationId());
	}

	@Test
	void testTrainArrivalDetails() {

		TrainArrivalDetails trainArrivalDetails = new TrainArrivalDetails(
				56732,
				23467,
				2);

		TrainArrivalRequest trainArrivalRequest = new TrainArrivalRequest(
				56732,
				23467,
				2);

		when(trainArrivalRepository.save(trainArrivalDetails)).thenReturn(trainArrivalDetails);
		assertEquals(56732,trainServices.saveTrainArrivalDetails(trainArrivalRequest).getStationId());
	}

	@Test
	void testTrainDepartureDetails() {
		TrainDepartureDetails trainDepartureDetails = new TrainDepartureDetails(
				56732,
				23467,
				3);

		TrainDepartureRequest trainDepartureRequest = new TrainDepartureRequest(
				56732,
				23467,
				3);

		when(trainDepartureRepository.save(trainDepartureDetails)).thenReturn(trainDepartureDetails);
		assertEquals(56732,trainServices.saveTrainDepartureDetails(trainDepartureRequest).getStationId());
	}

}
