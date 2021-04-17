package com.refyneassignment.service;

import com.refyneassignment.entity.Car;
import com.refyneassignment.entity.CarUserTable;
import com.refyneassignment.repository.CarRepository;
import com.refyneassignment.repository.CarUserTableRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class CarService {

    @Autowired
    private CarRepository carRepository ;

    @Autowired
    private CarUserTableRepository carUserTableRepository;
    
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



    public Long calculatePriceByTime(String fromDateTime, String toDateTime, Long carId) {
        Long totalCost=null;
        try{
            log.info("Going to get car by car id={}", carId);
            Car car= carRepository.findByCarId(carId);
            log.info("car={}", car);
            Long basePrice= car.getBasePrice();
            Long pph= car.getPricePerHour();
            SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date d1=format.parse(fromDateTime);
            Date d2=format.parse(toDateTime);
            long timeDifference= d2.getTime()- d1.getTime();
            log.info("timeDifference={}", timeDifference);
            long hourDifference=(timeDifference / (1000*60*60)) % 24;
            log.info("hourDifference={}", hourDifference);

            totalCost= basePrice + pph*(hourDifference + 1);
            log.info("price in rupees={}", totalCost);
        }catch(Exception e ){
            log.error("Error inside calculatePriceByTime e.message={} ",e.getStackTrace());
        }
        return totalCost;
    }

    public Map<String,String> book(String fromDateTime, String toDateTime, Long userId) {
        Map<String,String> map=new HashMap<>();
        try {
            if(fromDateTime!=null && toDateTime!=null && userId!=null){
                List<Car> unbookedCarLst=carRepository.getAllUnbookedCarList();
                log.info("unbooked car list ={} and the first car above them={}", unbookedCarLst.size(),unbookedCarLst.get(0));
                SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                Date d1=format.parse(fromDateTime);
                Date d2=format.parse(toDateTime);
                Car newcar= unbookedCarLst.get(0);
                newcar.setToDateTime(d1);
                newcar.setFromDateTime(d2);
                newcar.setBooked(true);
                carRepository.saveAndFlush(newcar);
                map.put("Message","SUCCESS");
                map.put("Remark","BOOKED SUCCESSFULLY");
                log.info("No Error till here");

                CarUserTable carUserTable= new CarUserTable();
                carUserTable.setCarId(newcar.getCarId());
                carUserTable.setUserId(userId);
                carUserTable.setFromDateTime(d1);
                carUserTable.setToDateTime(d2);
                log.info("Going to create new carUserTable");
                carUserTableRepository.save(carUserTable);
            }else{
                map.put("Message","FAILED");
                map.put("Remark","NOT BOOKED");

            }




        }catch(Exception e){
            log.error("Error inside book method of class carService");
            map.put("Message","FAILED");
            map.put("Remark","NOT BOOKED");
        }
        return  map;
    }
}
