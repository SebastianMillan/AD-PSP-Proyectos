package com.salesianostriana.dam._EjemploDTO.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam._EjemploDTO.model.Monumento;
import com.salesianostriana.dam._EjemploDTO.repository.MonumentoRepository;
import com.salesianostriana.dam._EjemploDTO.views.MonumentoView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/monumento")
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    @GetMapping("/")
    @JsonView(MonumentoView.MonumentoDetails.class)
    public ResponseEntity<List<Monumento>> getAll(){
        return ResponseEntity.ok(monumentoRepository.findAll());

    }

    @GetMapping("/{id}")
    @JsonView(MonumentoView.MonumentoList.class)
    public ResponseEntity<Monumento> findByID(@PathVariable Long id){
        return ResponseEntity.of(monumentoRepository.findById(id));
    }


}
