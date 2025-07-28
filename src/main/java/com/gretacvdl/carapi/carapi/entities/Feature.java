package com.gretacvdl.carapi.carapi.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long featureId;
    private String name;
    private String description;


    @ManyToMany(mappedBy = "features")
    private List<Car> cars;

    public Feature() {
    }
    public Long getFeatureId() {
        return featureId;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
