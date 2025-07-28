package com.gretacvdl.carapi.carapi.repositories;

import com.gretacvdl.carapi.carapi.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Object> findByEmail(String email);
}
