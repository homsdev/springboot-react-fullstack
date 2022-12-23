package com.homsdev.cardatabase.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

/**
 * Extend CrudRepository<T,ID> for providing basic crud operations
 * Extend PagingAndSortingRepository<T,ID> for retrieve entities using paging and sorting abstraction
 * -@RepositoryRestResource to use different path data for the generated REST service
 */
@RepositoryRestResource(path = "vehicles")
public interface CarRepository extends CrudRepository<Car, Long> {

    @Query("select c from Car c where c.brand = ?1")
    List<Car> findByBrand(@Param("brand") String brand);

    List<Car> findByColor(@Param("color") String color);

    List<Car> findByYearFrom(int year);

    List<Car> findByBrandAndModel(String brand, String Model);

    List<Car> findByBrandOrColor(String brand, String Color);

    List<Car> findByBrandOrderByYearFrom(String brand);
}
