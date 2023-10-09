package com.salesianostriana.dam._EjemploDTO.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam._EjemploDTO.model.Ruta;
import com.salesianostriana.dam._EjemploDTO.repository.RutaRepository;
import com.salesianostriana.dam._EjemploDTO.views.RutaView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ruta")
public class RutaController {

    private final RutaRepository rutaRepository;

    @GetMapping("/")
    @JsonView(RutaView.RutaList.class)
    public ResponseEntity<List<Ruta>> getAll(){

        return ResponseEntity.ok(rutaRepository.findAll());

    }

    @PostMapping("/")
    public ResponseEntity<Ruta> createRuta(@RequestBody @JsonView(RutaView.RutaEdit.class) Ruta nuevo){
        return ResponseEntity.status(201).body(rutaRepository.save(nuevo));
    }
}
