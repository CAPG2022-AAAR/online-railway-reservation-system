package com.orrs.availabletraininfo.repositories;


import com.orrs.availabletraininfo.trainDetails.TrainArrivalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainArrivalRepository extends JpaRepository<TrainArrivalDetails, Long>{
}
