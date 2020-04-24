package com.eventtime.service;

import org.springframework.stereotype.Service;

@Service
public class TimeToWordsService {
	
	public String timeToWords(int h, int m) {
		String time[] = {"zero", "one", "two", "three", "four","five", "six", "seven", "eight", "nine","ten", "eleven", "twelve", "thirteen","fourteen", "fifteen", "sixteen", "seventeen","eighteen", "nineteen", "twenty", "twenty one","twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven","twenty eight", "twenty nine"};
        String timeString = null;
        if(m == 00) timeString = time[h] + " o' clock";
        else if (m == 1) timeString = "one minute past " + time[h];
        else if (m == 59) timeString = "one minute to " + time[h+1];
        else if (m == 15) timeString = "quarter past " + time[h];
        else if (m == 30) timeString = "half past " + time[h];
        else if (m == 45) timeString = "quarter to " + time[h+1];
        else if (m < 30) timeString = time[m] + " minutes past " + time[h];
        else timeString = time[60 - m] + " minutes to " + time[h+1];
        return timeString;
	}

}
