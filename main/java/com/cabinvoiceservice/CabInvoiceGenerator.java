package com.cabinvoiceservice;

public class CabInvoiceGenerator {
    //constants
    private static final int COST_PER_MIN_TIME = 1;
    private static final double  MINIMUM_COST_PER_KILOMETER = 10;

    //method to calculate and return total fare
    public double calculateFare(double distance, int time) {
        return distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MIN_TIME;
    }
}
