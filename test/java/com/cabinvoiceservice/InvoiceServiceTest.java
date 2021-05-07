package com.cabinvoiceservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    CabInvoiceGenerator invoiceGenerator = null;
    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }
    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare(){
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }
    @Test
    public void givenMultipleRides_ShouldReturnTotalFare(){
        Ride[] rides = {    new Ride(2.0, 5),
                            new Ride(0.1, 1)
                        };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30,invoiceSummary.getTotalFare(),0.0);
    }
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary(){
        Ride[] rides = {    new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }
    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        Ride[] rides = {  new Ride(2.0, 5),
                          new Ride(0.1, 1)
        };
        Ride[] rideS=  {  new Ride(3.0,5),
                          new Ride(5,5),
                          new Ride(0.1,2)
        };
        User[] users = {  new User(101, rides),
                          new User(102, rideS)
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.getUserInvoice(102,users);
        System.out.println(invoiceSummary);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3,95);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }
    @Test
    public void givenUserWith_NormalAndPremiumRides_ShouldReturnProperInvoiceSummary() {
        Ride[] rides = {  new Ride(2.0, 5,"NORMAL"),
                new Ride(0.1, 1,"PREMIUM")
        };
        Ride[] rideS=  {  new Ride(3.0,5,"PREMIUM"),
                new Ride(2.0,5,"NORMAL"),
                new Ride(0.1,2,"PREMIUM")
        };
        User[] users = {  new User(101, rides),
                new User(102, rideS)
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.getUserInvoice(102,users);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3,100);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }
}
