package com.orrs.availabletraininfo.repositories;

import com.orrs.availabletraininfo.trainDetails.StationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StationRepository extends JpaRepository<StationDetails , Long> {

}
