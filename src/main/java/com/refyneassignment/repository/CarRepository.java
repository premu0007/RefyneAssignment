package com.refyneassignment.repository;

import com.refyneassignment.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long > {

    Car findByCarId(Long carId);

    @Query("SELECT c from Car c where c.isBooked=false")
    List<Car> getAllUnbookedCarList();

//new message
//    @Query("select * from Car c where c.model='honda'")
//    List<Car> findAllCarsByModel(String model);
}
