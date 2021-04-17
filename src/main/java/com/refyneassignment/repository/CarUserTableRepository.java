package com.refyneassignment.repository;

import com.refyneassignment.entity.CarUserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarUserTableRepository extends JpaRepository<CarUserTable,Long> {


    @Query("SELECT c from CarUserTable c where c.carId= ?1")
    List<CarUserTable> findAllByCarId(Long carId);
}
