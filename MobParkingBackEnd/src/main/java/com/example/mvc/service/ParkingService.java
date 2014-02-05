package com.example.mvc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.mvc.entity.Parking;



public interface ParkingService {
	
	Parking findByMsisdn(String msisdn);
	
	Parking findByCode(Long tUid);
	
	void deleteByCode(Long code);
	
	
	Parking insert(Parking topup);
	
	Parking update(Parking topup);

	List<Parking> findAll();

	Page<Parking> findAll(int page, int size);
	

}