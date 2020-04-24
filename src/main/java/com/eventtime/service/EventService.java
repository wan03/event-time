package com.eventtime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventtime.bean.Events;
import com.eventtime.repository.EventRepository;

@Service
public class EventService {
	
	private EventRepository eventRepository;
	
	@Autowired 
	private void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	@Autowired
	private TimeToWordsService timeToWordsService;
	
	public List<Events> getAllEvents() {
		return eventRepository.findAll();
	}
	
	public Events getEventById(int id) {
		
		return eventRepository.getOne(id);

		
		
	}
	
	public Events createEvent(Events event) {
		
		String timeWord = timeToWordsService.timeToWords(event.getTime().getHour(), event.getTime().getMinutes());
		
		event.setTimeWord(timeWord);
		
		return eventRepository.save(event);
	}
	
	public Events updateEvent(Events event) {
		
		return eventRepository.save(event);
	}
	
	public void deleteEvent(Events event) {
		
		eventRepository.delete(event);
	}
	
}
