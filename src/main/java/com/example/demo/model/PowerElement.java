package com.example.demo.model;

import java.util.UUID;

public class PowerElement {

    private int id;
    private String brand;
    private String substanceAnode;
    private String substanceCatode;
    private String electrolyte;
    private int capacity;

    private int voltage;

    public void setId(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setSubstanceAnode(String substanceAnode) {
        this.substanceAnode = substanceAnode;
    }

    public String getSubstanceAnode() {
        return substanceAnode;
    }


    public void setSubstanceCatode(String substanceCatode) {
        this.substanceCatode = substanceCatode;
    }

    public String getSubstanceCatode() {
        return substanceCatode;
    }

    public void setElectrolyte(String electrolyte) {
        this.electrolyte = electrolyte;
    }

    public String getElectrolyte() {
        return electrolyte;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
    public int getVoltage() {
        return voltage;
    }

    public PowerElement(String brand, String substanceAnode, String substanceCatode, int capacity, int voltage, int id  ) {
        this.id = id;
        this.brand = brand;
        this.substanceAnode = substanceAnode;
        this.substanceCatode = substanceCatode;
        this.capacity = capacity;
        this.voltage = voltage;
    }

    public String toString() {
        return "Element{"
                + "id='" + id + '\n'
                + "brand='" + brand + '\n'
                + "substanceAnode='" + substanceAnode + '\n'
                + "substanceCatode='" + substanceCatode + '\n'
                + "capacity='" + capacity + '\n'
                + "voltage='" + voltage + '\n'
                + '}';
    }
}
