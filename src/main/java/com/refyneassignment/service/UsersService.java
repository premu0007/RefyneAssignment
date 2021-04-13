package com.refyneassignment.service;

import com.refyneassignment.entity.Users;
import com.refyneassignment.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Users saveUsers(Users users) {
        log.info("Inside saveUsers of UsersService ");
        return usersRepository.save(users);
    }

    public Users findByUserId(Long userId) {
        log.info("Inside saveUsers of UsersService ");
        return usersRepository.findByUserId(userId);
    }

    public List<Users> findAllUsers() {
        log.info("Inside findAllUsers of UsersService");
        return  usersRepository.findAll();
    }

    public void deleteById(Long userId) {
        usersRepository.deleteById(userId);
    }


    public Users updateById(Long userId, Users users) {
        log.info("Inside service class updateById");
        try{
            Users users1=null;
            if(userId!=null && users!=null){
                String name=users.getName();
                Long mobileNo= users.getMobileNo();
                log.info("Going to update name={} and mobile number={} for userID={}", name,mobileNo,userId);
               return  usersRepository.updateById(name,mobileNo,userId);
            }
        }catch (Exception e){
            log.error("Error inside updateById ERROR={}",e.getStackTrace());

        }
        return null;
    }
}
