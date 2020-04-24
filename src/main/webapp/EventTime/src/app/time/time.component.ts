import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-time',
  templateUrl: './time.component.html',
  styleUrls: ['./time.component.css']
})
export class TimeComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {

    setInterval(this.getCurrentTime, 5000);
  }

  currentTime;

  getCurrentTime(){

    let dateTime = new Date();

    let hours = dateTime.getHours;
    let minutes = dateTime.getMinutes;

    let request:Object = {h: hours, m:minutes};

    this.http.get("http://localhost:8080/time", request).subscribe(res => this.currentTime = res);


  }

}
