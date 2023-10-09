package com.salesianostriana.dam._EjemploDTO.controller;

import com.salesianostriana.dam._EjemploDTO.dto.GetMonumentoDTO;
import com.salesianostriana.dam._EjemploDTO.model.Monumento;
import com.salesianostriana.dam._EjemploDTO.repository.MonumentoRepository;
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
    public ResponseEntity<List<GetMonumentoDTO>> getAll(){
        List<Monumento> lista = monumentoRepository.findAll();
        if(lista.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(lista.stream()
                .map(GetMonumentoDTO::of)
                .toList());

    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMonumentoDTO> findByID(@PathVariable Long id){
        return ResponseEntity.of(monumentoRepository.findById(id)
                .map(GetMonumentoDTO::of));
    }


}
