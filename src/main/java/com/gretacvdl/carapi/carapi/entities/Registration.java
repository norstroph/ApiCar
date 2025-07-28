package com.gretacvdl.carapi.carapi.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registrationId;
    private String plateNumber;
    private Date experitedate;
    @OneToOne
    private Car car;

    public Registration() {
    }

    public Long getRegistrationId() {
        return registrationId;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public Date getExperitedate() {
        return experitedate;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public void setExperitedate(Date experitedate) {
        this.experitedate = experitedate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
