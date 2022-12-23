package com.homsdev.cardatabase.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * ORM: Technique to fetch and manipulate databases by using object-oriented paradigm
 * JPA: Java persistence API
 * Hibernate. JAVA ORM implementation for Java
 */

/**
 * Add @Entity to a POJO that represents data that can be persisted in database
 * Each entity must have a primary key indicated by @Id
 */
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Car() {
    }

    public Car(String brand, String model, String color, String registerNumber, int yearFrom, int price,Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.yearFrom = yearFrom;
        this.price = price;
        this.owner = owner;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


}
