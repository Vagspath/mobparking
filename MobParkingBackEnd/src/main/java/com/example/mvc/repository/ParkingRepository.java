package com.example.mvc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mvc.entity.Parking;




public interface ParkingRepository extends JpaRepository<Parking, Long> {
	
	  Page<Parking> findByParkingIdLike(long parkingId, Pageable pageable);
}
