package com.salesianostriana.dam._EjemploDTO.service;

import com.salesianostriana.dam._EjemploDTO.dto.EditRutaDto;
import com.salesianostriana.dam._EjemploDTO.model.Dificultad;
import com.salesianostriana.dam._EjemploDTO.model.Monumento;
import com.salesianostriana.dam._EjemploDTO.model.Ruta;
import com.salesianostriana.dam._EjemploDTO.repository.MonumentoRepository;
import com.salesianostriana.dam._EjemploDTO.repository.RutaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RutaService {

    private final RutaRepository rutaRepository;
    private final MonumentoRepository monumentoRepository;

    public Ruta save(EditRutaDto nuevo){
        Ruta r = Ruta.builder()
                    .nombre(nuevo.nombre())
                    .tiempo(nuevo.duracion())
                    .dificultad(Dificultad.valueOf(nuevo.dificultad()))
                    .build();

        List<Monumento> monumento = nuevo.monumentos()
                .stream()
                .map(monumentoRepository::getReferenceById)
                .toList();

        r.setLista(monumento);
        return rutaRepository.save(r);
    }
}
