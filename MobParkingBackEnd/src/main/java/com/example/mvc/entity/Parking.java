package com.example.mvc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking")
public class Parking {

private static final long serialVersionUID = 1L;
	
	private long parkingId;
	
	private int duration;//minutes
	
	private Date timeOfEntrance;
	
	private Date timeOfExit;
	
	private  String customer;
	
	private  String carLicence;//pinakides
	
	private float cost;
	
	private boolean payed;

	
	@Id
	public long getParkingId() {
		return parkingId;
	}

	public void setParkingId(long parkingId) {
		this.parkingId = parkingId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getTimeOfEntrance() {
		return timeOfEntrance;
	}

	public void setTimeOfEntrance(Date timeOfEntrance) {
		this.timeOfEntrance = timeOfEntrance;
	}

	public Date getTimeOfExit() {
		return timeOfExit;
	}

	public void setTimeOfExit(Date timeOfExit) {
		this.timeOfExit = timeOfExit;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCarLicence() {
		return carLicence;
	}

	public void setCarLicence(String carLicence) {
		this.carLicence = carLicence;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}
	
	
}
