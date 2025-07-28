package com.gretacvdl.carapi.carapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OwnerId ;
    private String name;
    @Email(message = "Format d’email invalide")
    @NotBlank(message = "L’email est requis")
    private String email;
    @NotBlank(message = "Le mot de passe est requis")
    private String password;
    @OneToOne
    private Car car;

    public Owner() {
    }
    public Owner(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Long getOwnerId() {
        return OwnerId;
    }

    public @Email(message = "Format d’email invalide") @NotBlank(message = "L’email est requis") String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setOwnerId(Long OwnerId) {
        this.OwnerId = OwnerId;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public @NotBlank(message = "Le mot de passe est requis") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Le mot de passe est requis") String password) {
        this.password = password;
    }
}
