package com.homsdev.cardatabase.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long carId;
    private String brand, model, color, registerNumber;
    private int yearFrom, price;

    /**
     * EAGER: Defines that data must be eagerly fetched.
     * LAZY: Defines that data can be lazily fetched.
     */
    /*
    Setting ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;
     */

    /**
     *
     */
    @ManyToMany(mappedBy = "cars")
    private Set<Owner> owners = new HashSet<>();

    public Car() {
    }

    public Car(String brand, String model, String color, String registerNumber, int yearFrom, int price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.yearFrom = yearFrom;
        this.price = price;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(int yearFrom) {
        this.yearFrom = yearFrom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /* @ManyToOne getters & setters
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
     */

    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }
}
