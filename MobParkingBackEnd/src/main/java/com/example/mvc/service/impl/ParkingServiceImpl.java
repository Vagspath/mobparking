package com.example.mvc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.entity.Parking;

import com.example.mvc.repository.ParkingRepository;
import com.example.mvc.service.ParkingService;


@Service("ParkingService")
public class ParkingServiceImpl implements ParkingService {
	
	@Inject
	private ParkingRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Parking> findAll() {
		
		List<Parking> topups = this.repository.findAll();
		return topups;
	}
	

    @Override
    @Transactional(readOnly = true)
    public Page<Parking> findAll(int page, int size) {
        Pageable pageable = new PageRequest(page, size, new Sort(
                Direction.DESC, "ParkingId"));
        Page<Parking> paraggelies = repository.findAll(pageable);
        return paraggelies ;
    }
    
	@Override
	@Transactional(readOnly = true)
	public Parking findByMsisdn(String msisdn) {
		
		return null;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Parking findByCode(Long code) {
		
		return this.repository.findOne(code);
	}
	
	@Override
	@Transactional
	public Parking insert(Parking topup) {
		
		return this.repository.saveAndFlush(topup);
		
	}
	
	@Override
	@Transactional
	public Parking update(Parking topup) {
		return this.repository.save(topup);
	}
	
	@Override
	@Transactional
	public void deleteByCode(Long code) {
		this.repository.delete(code);
	}

	
	
	
	
}
