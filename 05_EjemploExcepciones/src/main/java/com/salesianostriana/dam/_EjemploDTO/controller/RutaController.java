package com.salesianostriana.dam._EjemploDTO.controller;

import com.salesianostriana.dam._EjemploDTO.dto.EditRutaDto;
import com.salesianostriana.dam._EjemploDTO.dto.GetRutaDTO;
import com.salesianostriana.dam._EjemploDTO.model.Ruta;
import com.salesianostriana.dam._EjemploDTO.repository.RutaRepository;
import com.salesianostriana.dam._EjemploDTO.service.RutaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ruta")
@Validated
public class RutaController {

    private final RutaRepository rutaRepository;
    private final RutaService rutaService;

    @PostMapping("/")
    public ResponseEntity<GetRutaDTO> createRuta(@Valid @RequestBody EditRutaDto nuevo){
        return ResponseEntity.status(201).body(GetRutaDTO.of(rutaService.save(nuevo)));
    }
}
