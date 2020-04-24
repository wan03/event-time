package com.eventtime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventtime.bean.Events;

@Repository
public interface EventRepository  extends JpaRepository<Events, Integer> {
	

}
