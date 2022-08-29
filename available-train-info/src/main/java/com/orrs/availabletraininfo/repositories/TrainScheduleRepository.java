package com.orrs.availabletraininfo.repositories;

import com.orrs.availabletraininfo.trainDetails.TrainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainScheduleRepository extends JpaRepository<TrainSchedule , Long> {
}
