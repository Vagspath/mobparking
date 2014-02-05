package com.example.mvc.repository.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.mvc.entity.Parking;

public interface ParkingRepositoryCustom {

	  Page<Parking> findByParkingIdLike(long parkingId, Pageable pageable);
	}
