package com.gretacvdl.carapi.carapi.controllers;

import com.gretacvdl.carapi.carapi.dtos.CarRequestDTO;
import com.gretacvdl.carapi.carapi.entities.Car;
import com.gretacvdl.carapi.carapi.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> allCar = carService.getAllCars() ;
        return ResponseEntity.status(200).body( allCar);
    }



    @GetMapping("/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable Long carId) {
        Car car = carService.getCarById(carId);
        return ResponseEntity.ok(car);
    }


    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody CarRequestDTO carRequestDTO) {
        Car createdCar = carService.createCar(carRequestDTO);
        return ResponseEntity.status(201).body(createdCar);
    }


    @PutMapping("/{carId}")
    public ResponseEntity<Car> updateCar(@PathVariable Long carId, @RequestBody CarRequestDTO carRequestDTO) {
        Car updatedCar = carService.updateCar(carId, carRequestDTO);
        return ResponseEntity.ok(updatedCar);
    }


    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId) {
        carService.deleteCar(carId);
        return ResponseEntity.noContent().build();
    }
}