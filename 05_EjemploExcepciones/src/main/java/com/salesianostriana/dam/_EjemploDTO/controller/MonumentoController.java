package com.salesianostriana.dam._EjemploDTO.controller;

import com.salesianostriana.dam._EjemploDTO.dto.GetMonumentoDTO;
import com.salesianostriana.dam._EjemploDTO.exception.MonumentoNotFoundException;
import com.salesianostriana.dam._EjemploDTO.model.Monumento;
import com.salesianostriana.dam._EjemploDTO.repository.MonumentoRepository;
import com.salesianostriana.dam._EjemploDTO.service.MonumentoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/monumento")
public class MonumentoController {

    private final MonumentoServicio monumentoServicio;

    @GetMapping("/{id}")
    public GetMonumentoDTO findByID(@PathVariable Long id){
        return GetMonumentoDTO.of(monumentoServicio.findById(id));
    }


}
