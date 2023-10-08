package com.salesianostriana.dam._EjemploDTO.controller;

import com.salesianostriana.dam._EjemploDTO.dto.GetRutaDTO;
import com.salesianostriana.dam._EjemploDTO.model.Ruta;
import com.salesianostriana.dam._EjemploDTO.repository.RutaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ruta")
public class RutaController {

    private final RutaRepository rutaRepository;

    @GetMapping("/")
    public ResponseEntity<List<GetRutaDTO>> getAll(){

        List<Ruta> lista = rutaRepository.findAll();

        if(lista.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                lista.stream()
                        .map(GetRutaDTO::of)
                        .toList()
        );

    }
}
