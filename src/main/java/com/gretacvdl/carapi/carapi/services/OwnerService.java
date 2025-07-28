package com.gretacvdl.carapi.carapi.services;

import com.gretacvdl.carapi.carapi.dtos.OwnerRequestDTO;
import com.gretacvdl.carapi.carapi.dtos.OwnerResponseDTO;
import com.gretacvdl.carapi.carapi.entities.Owner;
import com.gretacvdl.carapi.carapi.exception.DuplicateEmailException;
import com.gretacvdl.carapi.carapi.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public OwnerResponseDTO newOwner(OwnerRequestDTO request) {
        if (ownerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateEmailException("Cet email est déjà utilisé : " + request.getEmail());
        }

        Owner owner = new Owner();
        owner.setName(request.getName());
        owner.setEmail(request.getEmail());
        owner.setPassword(request.getPassword());

        Owner saved = ownerRepository.save(owner);

        OwnerResponseDTO response = new OwnerResponseDTO();
        response.setOwnerId(saved.getOwnerId());
        response.setName(saved.getName());
        response.setEmail(saved.getEmail());

        if (saved.getCar() != null) {
            response.setCarId(saved.getCar().getCarId());
        }

        return response;
    }

}

