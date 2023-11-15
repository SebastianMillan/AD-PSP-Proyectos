package com.salesianostriana.dam._EjemploDTO.service;

import com.salesianostriana.dam._EjemploDTO.exception.MonumentoNotFoundException;
import com.salesianostriana.dam._EjemploDTO.model.Monumento;
import com.salesianostriana.dam._EjemploDTO.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MonumentoServicio {

    private final MonumentoRepository monumentoRepository;

    public Monumento findById(Long id){
        return monumentoRepository.findById(id)
                .orElseThrow(MonumentoNotFoundException::new);
    }
}
