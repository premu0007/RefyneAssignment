package com.refyneassignment.controller;

import com.refyneassignment.entity.Users;
import com.refyneassignment.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

    @Autowired
    private UsersService service;

    @PostMapping("/save")
    public  Users saveUsers(@RequestBody  Users users){
        log.info("Inside Method saveUsers of UsersController");
        return service.saveUsers(users);
    }

    @GetMapping("/findByUserId/{id}")
    public Users findByUserId(@PathVariable("id") Long userId){
        log.info("Inside Method saveUsers of UsersController");
        return service.findByUserId(userId);
    }


    @GetMapping("/findAllUsers")
    public List<Users> findAllUsers(){
        log.info("Inside Method saveUsers of UsersController");
        return service.findAllUsers();
    }


    @GetMapping("/deleteById/{id}")
    public Map<String,String> deleteById(@PathVariable("id") Long userId){
        log.info("Inside Method saveUsers of UsersController");
        Map<String,String> map= new HashMap<>();
        try{
             service.deleteById(userId);
             map.put("REMARK","SUCCESS");
             map.put("MESSGAE","DELETED SUCCESSFULLY");

        }catch (Exception e){
            map.put("REMARK","FAILED");
            map.put("MESSGAE","NOT ABLE TO DELETE ");
        }
        return  map;
    }

    @PostMapping("/updateById/{id}")
    public  Users updateById(@PathVariable("id") Long userId, @RequestBody  Users users){
        log.info("Inside Method updateById userId={}",userId);
        return service.updateById(userId,users);
    }
}
