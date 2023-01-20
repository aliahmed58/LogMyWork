package com.main.logmywork.objects;

import java.time.LocalTime;

public class Time {

    private String timeString;
    private LocalTime time;

    public Time() {
        this.time = LocalTime.of(0, 0, 0);
        this.timeString = time.toString();
    }

    public Time(int hours, int minutes, int seconds) {
        // init LocalTime given the hours minutes and seconds
        this.time = LocalTime.of(hours, minutes, seconds);
        // also generate a string for it to be displayed
        this.timeString = time.toString();
    }

    // method sets the time according to hours minutes and seconds
    public void setTime(int hours, int minutes, int seconds) {
        this.time = LocalTime.of(hours, minutes, seconds);
        this.timeString = this.time.toString();
    }

    // method to add time to local time object and update the string accordingly
    public void addTime(int seconds) {
        this.time = this.time.plusSeconds(seconds);
        this.timeString = this.time.toString();
    }

    public String getTimeString() {
        return this.timeString;
    }
}
