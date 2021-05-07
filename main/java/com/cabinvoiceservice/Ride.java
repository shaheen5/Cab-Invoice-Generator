package com.cabinvoiceservice;

public class Ride {
    public double distance;
    public int time;
    public String type;

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.type = "NORMAL";
    }
    public Ride(double distance, int time,String type) {
        this.distance = distance;
        this.time = time;
        this.type = type;
    }
}
