package com.gretacvdl.carapi.carapi.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class OwnerRequestDTO {

    @NotBlank(message = "Le nom est requis")
    private String name;

    @Email(message = "Format d’email invalide")
    @NotBlank(message = "L’email est requis")
    private String email;

    @NotBlank(message = "Le mot de passe est requis")
    @Size(min = 5, message = "Le mot de passe doit faire au moins 5 caractères")
    private String password;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

