package com.gretacvdl.carapi.carapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long car_id;
    
    private Double price;
    private String model;
    @OneToOne
    private Owner owner;

    @OneToOne
    @JoinColumn(name = "registration_id", referencedColumnName = "registrationId")
    private Registration registration;
    @ManyToMany
    @JoinTable(name = "car_feature", joinColumns = @JoinColumn(name = "car_id"), inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private List<Feature> features;


    public Car() {
    }

    public Long getCar_id() {
        return car_id;
    }

    public Double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public Owner getOwner() {
        return owner;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Long getCarId() {
        return car_id;
    }
}
