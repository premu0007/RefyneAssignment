package com.refyneassignment.service;

import com.refyneassignment.entity.CarUserTable;
import com.refyneassignment.repository.CarUserTableRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarUserService {
    @Autowired
    private CarUserTableRepository carUserTableRepository;

    public List<CarUserTable> findUsersListByCarId(Long carId) {
        log.info("Going to get all users detail by car id={}", carId);
       return  carUserTableRepository.findAllByCarId(carId);
    }
}
