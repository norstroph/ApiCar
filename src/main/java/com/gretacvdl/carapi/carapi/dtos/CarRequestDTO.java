package com.gretacvdl.carapi.carapi.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CarRequestDTO {

    @NotBlank(message = "Le modèle ne peut pas être vide")
    private String model;

    @NotNull(message = "Le prix est obligatoire")
    @Min(value = 0, message = "Le prix doit être supérieur ou égal à 0")
    private Double price;

    @NotNull(message = "L'année est obligatoire")
    private Integer year;

    @NotNull(message = "L'ID du propriétaire est requis")
    private Long ownerId;

    private Long registrationId;

    private List<Long> featureIds;



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public List<Long> getFeatureIds() {
        return featureIds;
    }

    public void setFeatureIds(List<Long> featureIds) {
        this.featureIds = featureIds;
    }
}
