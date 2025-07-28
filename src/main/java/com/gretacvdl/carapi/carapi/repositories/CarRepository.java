package com.gretacvdl.carapi.carapi.repositories;

import com.gretacvdl.carapi.carapi.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
