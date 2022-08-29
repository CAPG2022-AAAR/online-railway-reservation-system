package com.orrs.availabletraininfo.repositories;


import com.orrs.availabletraininfo.trainDetails.TrainDepartureDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainDepartureRepository extends JpaRepository <TrainDepartureDetails, Long> {
}
