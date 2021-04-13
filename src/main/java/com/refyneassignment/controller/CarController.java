package com.refyneassignment.controller;

import com.refyneassignment.entity.Car;
import com.refyneassignment.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cars")
@Slf4j
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/save")
    public Car saveNewCar(@RequestBody Car car){
        log.info("Inside saveNewCar method: going to save new car detail");
        return carService.saveNewCar(car);
    }

    @GetMapping("/findByCarId/{id}")
    public Car findByCarId(@PathVariable("id")  Long carLNumber){
        log.info("Inside findByCarId : Going to find car for ID={}", carLNumber);
        return carService.findByCarId(carLNumber);
    }

    @GetMapping("/searchCarsbyDate/fromDateTime/toDateTime")
    public List<Car> searchCarsbyDate(@PathVariable("fromDateTime") Date fromDateTime, @PathVariable("toDateTime") Date toDateTime){
        log.info("Inside searchCarsbyDate of class CarController ");
        return carService.searchCarsbyDate(fromDateTime,toDateTime);
    }

//    @PostMapping("")


//    @PostMapping("/update")
//    public Car updateCar(@RequestBody Car car){
//        log.info("Inside updateCar method: going to save new car detail");
//        return carService.updateCar(car);
//    }

        @GetMapping("/delete/{id}")
    public void deleteCarById(@PathVariable("id") Long carId){
        log.info("Inside deleteCarById method: going to delete new car detail");
         carService.deleteCar(carId);
    }

    @GetMapping("/findAllCars")
    public List<Car> findAllCars(){
        log.info("Going to get all cars in Data base");
        return carService.findAllCars();
    }
//    @GetMapping("/findCarByModel/{model}")
//    public List<Car> findAllCarsByModel(@PathVariable("model") String model){
//        log.info("Going to get all cars in Data base by model name ={}", model);
//        return carService.findAllCarsByModel(model);
//    }
}
