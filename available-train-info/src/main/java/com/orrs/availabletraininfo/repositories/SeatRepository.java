package com.orrs.availabletraininfo.repositories;

import com.orrs.availabletraininfo.trainDetails.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seats ,  Long> {

}
