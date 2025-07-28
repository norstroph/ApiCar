package com.gretacvdl.carapi.carapi;
import com.gretacvdl.carapi.carapi.entities.Car;
import com.gretacvdl.carapi.carapi.entities.Registration;
import com.gretacvdl.carapi.carapi.repositories.CarRepository;
import com.gretacvdl.carapi.carapi.repositories.RegistrationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CarLoader implements CommandLineRunner {

    private final CarRepository carRepository;
    private final RegistrationRepository registrationRepository;

    public CarLoader(CarRepository carRepository, RegistrationRepository registrationRepository) {
        this.carRepository = carRepository;
        this.registrationRepository = registrationRepository;
    }

    @Override
    public void run(String... args) {

        Registration reg1 = new Registration();
        reg1.setPlateNumber("AA-123-BB");
        reg1.setExperitedate(new Date());
        registrationRepository.save(reg1);
        Car car1 = new Car();
        car1.setModel("Clio");
        car1.setPrice(13500.0);
        car1.setRegistration(reg1);

        Car car2 = new Car();
        car2.setModel("208");
        car2.setPrice(14900.0);

        Car car3 = new Car();
        car3.setModel("Yaris");
        car3.setPrice(16000.0);

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
    }
}
