package com.gretacvdl.carapi.carapi.services;

import com.gretacvdl.carapi.carapi.dtos.CarRequestDTO;
import com.gretacvdl.carapi.carapi.entities.Car;
import com.gretacvdl.carapi.carapi.entities.Feature;
import com.gretacvdl.carapi.carapi.entities.Owner;
import com.gretacvdl.carapi.carapi.entities.Registration;
import com.gretacvdl.carapi.carapi.exception.ResourceNotFoundException;
import com.gretacvdl.carapi.carapi.repositories.CarRepository;
import com.gretacvdl.carapi.carapi.repositories.FeatureRepository;
import com.gretacvdl.carapi.carapi.repositories.OwnerRepository;
import com.gretacvdl.carapi.carapi.repositories.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;
    private final RegistrationRepository registrationRepository;
    private final FeatureRepository featureRepository;

    public CarService(CarRepository carRepository, OwnerRepository ownerRepository,
                      RegistrationRepository registrationRepository, FeatureRepository featureRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
        this.registrationRepository = registrationRepository;
        this.featureRepository = featureRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car n existe pas"));
    }

    public Car createCar(CarRequestDTO dto) {
        Car car = new Car();
        car.setModel(dto.getModel());
        car.setPrice(dto.getPrice());

        Owner owner = ownerRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new ResourceNotFoundException("Owner existe pas "));
        car.setOwner(owner);

        Registration registration = registrationRepository.findById(dto.getRegistrationId())
                .orElseThrow(() -> new ResourceNotFoundException("Registration not found"));
        car.setRegistration(registration);

        List<Feature> features = featureRepository.findAllById(dto.getFeatureIds());
        car.setFeatures(features);

        return carRepository.save(car);
    }

    public Car updateCar(Long id, CarRequestDTO dto) {
        Car car = getCarById(id);
        car.setModel(dto.getModel());
        car.setPrice(dto.getPrice());

        if (dto.getOwnerId() != null) {
            Owner owner = ownerRepository.findById(dto.getOwnerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Owner n existe pas"));
            car.setOwner(owner);
        }

        if (dto.getRegistrationId() != null) {
            Registration reg = registrationRepository.findById(dto.getRegistrationId())
                    .orElseThrow(() -> new ResourceNotFoundException("Registration n existe pas"));
            car.setRegistration(reg);
        }

        if (dto.getFeatureIds() != null) {
            List<Feature> features = featureRepository.findAllById(dto.getFeatureIds());
            car.setFeatures(features);
        }

        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }





}
