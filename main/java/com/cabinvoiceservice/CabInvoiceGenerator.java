package com.cabinvoiceservice;

public class CabInvoiceGenerator {
    //constants
    private static final int COST_PER_MIN_TIME = 1;
    private static final double  MINIMUM_COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5;
    private static final int PREMIUM_COST_PER_MIN_TIME = 2;
    private static final double  PREMIUM_MINIMUM_COST_PER_KILOMETER = 15;
    private static final double PREMIUM_MINIMUM_FARE = 20;

    //method to calculate and return total fare
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MIN_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    //method to calculate and return total fare for different rides
    public double calculateFare(Ride ride) {
        double totalFare = 0.0;
        if(ride.type.equalsIgnoreCase("NORMAL")) {
            totalFare = ride.distance * MINIMUM_COST_PER_KILOMETER + ride.time * COST_PER_MIN_TIME;
            return Math.max(totalFare, MINIMUM_FARE);
        }
        if(ride.type.equalsIgnoreCase("PREMIUM")) {
            totalFare = ride.distance * PREMIUM_MINIMUM_COST_PER_KILOMETER + ride.time * PREMIUM_COST_PER_MIN_TIME;
            return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
        }
        return 0;
    }
    //method to calculate fare for multiple rides
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }
    //method to get invoice summary of given userId from all users
    public InvoiceSummary getUserInvoice(int id,User[] users) {
        Ride[] rides = null;
        for(User user : users){
            if(user.userId == id){
                rides = user.getRides();
            }
        }
        InvoiceSummary invoiceSummary = calculateFare(rides);
        return invoiceSummary;
    }
}