package com.eventtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventtime.bean.Events;
import com.eventtime.service.EventService;

@RestController
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping(path = "/event")
	public List<Events> getAllEvents (){
		return eventService.getAllEvents();
	}
	
	@GetMapping(path= "/event/{id}")
	public Events getEventById (@PathVariable int id) {
		return eventService.getEventById(id);
	}
	
	@PostMapping(path="/event")
	public ResponseEntity<HttpStatus> addEvent (@RequestBody Events event){
		eventService.createEvent(event);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@PutMapping(path="/event")
	public ResponseEntity<HttpStatus> updateEvent (@RequestBody Events event){
		eventService.updateEvent(event);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/event")
	public ResponseEntity<HttpStatus> deleteEvent (@RequestBody Events event) {
		eventService.deleteEvent(event);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
