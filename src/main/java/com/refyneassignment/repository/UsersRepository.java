package com.refyneassignment.repository;


import com.refyneassignment.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long >{

    Users findByUserId(Long userId);

    @Modifying
    @Query("update Users u set  u.name= ?1 , u.mobileNo= ?2 where  u.userId= ?3")
    Users updateById(String name, Long mobileNo, Long userId);
}



