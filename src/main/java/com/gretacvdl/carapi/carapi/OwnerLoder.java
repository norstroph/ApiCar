package com.gretacvdl.carapi.carapi;

import com.gretacvdl.carapi.carapi.entities.Owner;
import com.gretacvdl.carapi.carapi.repositories.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OwnerLoder implements CommandLineRunner {

    private final OwnerRepository ownerRepository;

    public OwnerLoder(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setName("Alice");
        owner1.setEmail("alice@example.com");
        owner1.setPassword("alice123");

        Owner owner2 = new Owner();
        owner2.setName("Bob");
        owner2.setEmail("bob@example.com");
        owner2.setPassword("bob123");

        ownerRepository.save(owner1);
        ownerRepository.save(owner2);
    }
}