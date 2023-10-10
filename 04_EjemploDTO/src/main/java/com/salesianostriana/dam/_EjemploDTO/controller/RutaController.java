package com.salesianostriana.dam._EjemploDTO.controller;

import com.salesianostriana.dam._EjemploDTO.dto.EditRutaDto;
import com.salesianostriana.dam._EjemploDTO.dto.GetRutaDTO;
import com.salesianostriana.dam._EjemploDTO.model.Ruta;
import com.salesianostriana.dam._EjemploDTO.repository.RutaRepository;
import com.salesianostriana.dam._EjemploDTO.service.RutaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ruta")
public class RutaController {

    private final RutaRepository rutaRepository;
    private final RutaService rutaService;

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

    @GetMapping("/{id}")
    public ResponseEntity<GetRutaDTO> findById(@PathVariable Long id){
        return ResponseEntity.of(rutaRepository.findById(id)
                .map(GetRutaDTO::of));
    }

    @PostMapping("/")
    public ResponseEntity<GetRutaDTO> createRuta(@RequestBody EditRutaDto nuevo){
        return ResponseEntity.status(201).body(GetRutaDTO.of(rutaService.save(nuevo)));
    }
}
