package com.salesianostriana.dam.EjercicioDTOPareja.controller;

import com.salesianostriana.dam.EjercicioDTOPareja.dto.GetAlumnoDto;
import com.salesianostriana.dam.EjercicioDTOPareja.model.Alumno;
import com.salesianostriana.dam.EjercicioDTOPareja.model.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoRepository alumnoRepository;

    @GetMapping("/")
    public ResponseEntity<List<GetAlumnoDto>> getAll(){
        List<Alumno> lista = alumnoRepository.findAll();

        if(lista.isEmpty())
            return ResponseEntity.notFound().build();

        List<GetAlumnoDto> results = lista.stream()
                .map(GetAlumnoDto::of)
                .toList();

        return ResponseEntity.ok(results);
    }



}
