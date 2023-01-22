package com.driver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customer;

    private String mobile;

    private String password;
    public Customer(){

    }

    public String getPassword() {
        return password;
    }

    public int getCustomer() {
        return customer;
    }

    public String getMobile() {
        return mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<TripBooking> tripBookingList;

    public List<TripBooking> getTripBookingList() {
        return tripBookingList;
    }

    public void setTripBookingList(List<TripBooking> tripBookingList) {
        this.tripBookingList = tripBookingList;
    }

}

