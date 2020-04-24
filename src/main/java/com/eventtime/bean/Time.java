package com.eventtime.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Component
@Entity
@Table(name= "time")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "timeId")
public class Time {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="time_id")
	private int timeId;
	
	@Column(name="hour")
	private int hour;
	
	@Column(name="minutes")
	private int minutes;

	public int getTimeId() {
		return timeId;
	}

	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	
}
