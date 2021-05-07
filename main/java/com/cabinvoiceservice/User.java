package com.cabinvoiceservice;

import java.util.Arrays;
import java.util.List;

public class User {
    int userId;
    Ride [] rides;

    public User(int userId, Ride[] rides) {
        this.userId = userId;
        this.rides = rides;
    }

    //getter method to return user rides
    public Ride[] getRides() {
        return this.rides;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", rides=" + Arrays.toString(rides) +
                '}';
    }
}
