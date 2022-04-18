package com.example.meowmaven2.model;

public class Speaker {
    private String firstName, lastName;
    private double seedNum;

    public double getSeedNum() {
        return seedNum;
    }

    public void setSeedNum(double seedNum) {
        this.seedNum = seedNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
