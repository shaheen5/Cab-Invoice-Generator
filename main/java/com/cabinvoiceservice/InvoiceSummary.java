package com.cabinvoiceservice;

public class InvoiceSummary {
    private final int numOfRides;
    private final double totalFare;
    private  final double averageFare;

    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/this.numOfRides;
    }
    //getter method to get total fare
    public double getTotalFare(){
        return this.totalFare;
    }

    //override equals methods to compare two InvoiceSummary objects
    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) object;
        return  numOfRides==that.numOfRides &&
                Double.compare(totalFare,that.totalFare)==0 &&
                Double.compare(averageFare,that.averageFare)==0;
    }
}
