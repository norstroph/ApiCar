package com.gretacvdl.carapi.carapi.repositories;

import com.gretacvdl.carapi.carapi.entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}