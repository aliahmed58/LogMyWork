package com.main.logmywork.objects;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {

    private String timeString;
    private LocalTime time;
    // formatter object to format time into string
    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;

    public Time() {
        this.time = LocalTime.of(0, 0, 0);
        this.formatTimeString();
    }

    public Time(int hours, int minutes, int seconds) {
        // init LocalTime given the hours minutes and seconds
        this.time = LocalTime.of(hours, minutes, seconds);
        this.formatTimeString();
    }

    // method sets the time according to hours minutes and seconds
    public void setTime(int hours, int minutes, int seconds) {
        this.time = LocalTime.of(hours, minutes, seconds);
        this.timeString = this.time.toString();
    }

    // method to add time to local time object and update the string accordingly
    public void addTime(int seconds) {
        this.time = this.time.plusSeconds(seconds);
        this.formatTimeString();
    }

    // returns the formatted time string
    public String getTimeString() {
        return this.timeString;
    }

    // formats time string using the date time formatter in format of '00:00:00'
    private void formatTimeString() {
        this.timeString = time.format(formatter);
    }

    public LocalTime getTime() {
        return this.time;
    }
}
