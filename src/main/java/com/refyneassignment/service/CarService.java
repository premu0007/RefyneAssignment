package com.refyneassignment.service;

import com.refyneassignment.entity.Car;
import com.refyneassignment.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository ;
    
    public Car saveNewCar(Car car) {
        return carRepository.save(car);
    }

    public Car findByCarId(Long carId) {
        return carRepository.findByCarId(carId);
    }

//    public Car updateCar(Car car) {
//        return  carRepository.update(car);
//    }

    public void deleteCar(Long carId) {
          carRepository.deleteById(carId);
    }

    public List<Car> findAllCars() {
      return  carRepository.findAll();
    }
//
//    public List<Car> searchCarsbyDate(Date fromDateTime, Date toDateTime) {
//        List<Car> carList= new ArrayList<>();
//        return carList;
//
//    }
}
