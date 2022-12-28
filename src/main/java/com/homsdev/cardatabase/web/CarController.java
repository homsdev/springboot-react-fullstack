package com.homsdev.cardatabase.web;

import com.homsdev.cardatabase.domain.Car;
import com.homsdev.cardatabase.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private CarRepository carRepository;
    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RequestMapping(value = "/cars",method = RequestMethod.GET)
    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }


}
