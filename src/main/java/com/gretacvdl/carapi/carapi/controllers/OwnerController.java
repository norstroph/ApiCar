package com.gretacvdl.carapi.carapi.controllers;

import com.gretacvdl.carapi.carapi.dtos.CarRequestDTO;
import com.gretacvdl.carapi.carapi.dtos.OwnerRequestDTO;
import com.gretacvdl.carapi.carapi.dtos.OwnerResponseDTO;
import com.gretacvdl.carapi.carapi.entities.Owner;
import com.gretacvdl.carapi.carapi.services.OwnerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/newowner")
    public ResponseEntity<OwnerResponseDTO> newOwner(@Valid @RequestBody OwnerRequestDTO dto) {
        OwnerResponseDTO created = ownerService.newOwner(dto);

        OwnerResponseDTO response = new OwnerResponseDTO();
        response.setOwnerId(created.getOwnerId());
        response.setName(created.getName());
        response.setEmail(created.getEmail());
        return ResponseEntity.status(201).body(response);
    }
}
