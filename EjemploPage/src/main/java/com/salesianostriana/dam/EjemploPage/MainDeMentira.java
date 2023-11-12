package com.salesianostriana.dam.EjemploPage;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MainDeMentira {

    private final AlumnoRepository alumnoRepository;
    @PostConstruct
    public void run(){
        //alumnoRepository.getAlumnoDTOByInstituo()

        Page<Alumno> result = alumnoRepository.findAlumnoWithPages(PageRequest.of(0,20));
    }
}
