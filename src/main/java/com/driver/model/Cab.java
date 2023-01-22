package com.driver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int perKmRate;

    private boolean available;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private Driver driver;

    public int getId() {
        return id;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setPerKmRate(int perKmRate) {
        this.perKmRate = perKmRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public int getPerKmRate() {
        return perKmRate;
    }
    public Cab(int perKmRate,boolean available){
        this.perKmRate=perKmRate;
        this.available=available;
    }
    public Cab(){

    }
    public boolean getAvailable(){
        return available;
    }
}

