package com.refyneassignment.service;

import com.refyneassignment.entity.Car;
import com.refyneassignment.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
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

    public List<Car> searchCarsbyDate(Date fromDateTime, Date toDateTime) {
        List<Car>  result= new ArrayList<>();
        try{
            List<Car> newList= carRepository.findAll();
            for( int i=0; i<newList.size(); i++){
                if(newList.get(i).getFromDateTime().after(fromDateTime) && newList.get(i).getToDateTime().before(toDateTime)){
                    result.add(newList.get(i));
                }
            }

        }catch (Exception e){
            log.info("Error inside searchCarsbyDate: cause={}", e.getMessage());
        }
        return result;
    }

//






//
//    public List<Car> searchCarsbyDate(Date fromDateTime, Date toDateTime) {
//        List<Car> carList= new ArrayList<>();
//        return carList;
//
//    }
}
