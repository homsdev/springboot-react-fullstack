package com.homsdev.cardatabase.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;
import java.util.List;


public interface CarRepository extends CrudRepository<Car, Long> {

    @Query("select c from Car c where c.brand = ?1")
    List<Car> findByBrand(String brand);

    List<Car> findByColor(String color);

    List<Car> findByYearFrom(int year);

    List<Car> findByBrandAndModel(String brand, String Model);

    List<Car> findByBrandOrColor(String brand, String Color);

    List<Car> findByBrandOrderByYearFrom(String brand);
}
