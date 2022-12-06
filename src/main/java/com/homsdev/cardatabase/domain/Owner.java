package com.homsdev.cardatabase.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerId;

    private String name, lastname;

    /**
     * CASCADE: The operations that must be cascaded to the target of the association.
     * mappedBy: The field that owns the relationship. Specifies foreign key
     */
    /*
    @OneToMany relation definition
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private List<Car> car;
     */

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "car_owner",
            joinColumns = {@JoinColumn(name = "ownerid")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
    private Set<Car> cars = new HashSet<>();

    public Owner() {
    }

    public Owner(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /*
    Getter and setter @ManyToOne
    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }
     */
}
