package com.refyneassignment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarUserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  Long carId;
    private Long userId;
    private Date fromDateTime;
    private Date toDateTime;
}
