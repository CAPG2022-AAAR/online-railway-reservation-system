package com.orrs.availabletraininfo.trainDetailsRepository;

import com.orrs.availabletraininfo.trainDetails.Train_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainDetailsRepository extends JpaRepository<Train_details,Long> {
}
