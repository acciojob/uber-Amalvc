package com.driver.model;

import javax.persistence.*;

@Entity
@Table
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cabId;

    private int perKmRate;

    private boolean available;

    @OneToOne(mappedBy = "cab",cascade = CascadeType.ALL)
    Driver driver;

    public int getCabId() {
        return cabId;
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

    public void setCabId(int cabId) {
        this.cabId = cabId;
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

