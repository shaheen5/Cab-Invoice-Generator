package com.cabinvoiceservice;

public class CabInvoiceGenerator {
    //constants
    private static final int COST_PER_MIN_TIME = 1;
    private static final double  MINIMUM_COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5;

    //method to calculate and return total fare
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MIN_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }
    //method to calculate fare for multiple rides
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance,ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }
}
