package com.refyneassignment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;

    @Column(unique = true)
    private String carLicenseNumber;

    private String model;
    private String manufacturer;
    private Integer basePrice;
    private Integer pricePerHour;
    private Integer securityDeposit;
    private Date toDateTime;
    private Date fromDateTime;
}
