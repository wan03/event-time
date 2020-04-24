package com.eventtime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventtime.bean.Time;
import com.eventtime.service.TimeToWordsService;

@RestController
public class TimeController {
	
	@Autowired
	private TimeToWordsService timeToWordsService;
	
	@GetMapping(path = "/time")
	public String getTimeInWords (@RequestBody Time time) {
		
		int h = time.getHour();
		int m = time.getMinutes();
		
		return timeToWordsService.timeToWords(h, m);
		
	}

}
