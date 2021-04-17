package com.refyneassignment.controller;

import com.refyneassignment.entity.CarUserTable;
import com.refyneassignment.entity.Users;
import com.refyneassignment.service.CarUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/CarUserController")
public class CarUserController {
    @Autowired
    private CarUserService service;
    @GetMapping("/findUsersListByCarId/{carId}")
    public List<CarUserTable> findUsersListByCarId(@PathVariable("carId") Long carId){
        return service.findUsersListByCarId(carId);
    }

    @GetMapping("/findCarListByUserId/{userId}")
    public List<CarUserTable> findCarListByUserId(@PathVariable("userId") Long userId){
        return service.findCarListByUserId(userId);
    }
}
