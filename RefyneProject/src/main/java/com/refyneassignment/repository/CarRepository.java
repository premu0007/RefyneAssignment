package com.refyneassignment.repository;

import com.refyneassignment.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long > {

    Car findByCarId(Long carId);


}
