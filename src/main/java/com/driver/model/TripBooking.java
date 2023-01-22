package com.driver.model;

import javax.persistence.*;

@Entity
@Table
public class TripBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tripBookingId;

    private String fromLocation;

    private String toLocation;
    private int distanceInKm;

    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;

    private int bill;



    public int getDistanceInKm() {
        return distanceInKm;
    }

    public int getBill() {
        return bill;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }



    public void setBill(int bill) {
        this.bill = bill;
    }

    public void setDistanceInKm(int distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }
    public TripBooking(){

    }
    public TripBooking(String fromLocation,String toLocation,int distanceInKm,TripStatus tripStatus){
        this.fromLocation=fromLocation;
        this.toLocation=toLocation;
        this.distanceInKm=distanceInKm;
        this.tripStatus=tripStatus;

    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @ManyToOne
    @JoinColumn
    private Driver driver;

    public int getTripBookingId() {
        return tripBookingId;
    }
}

