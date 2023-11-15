package com.salesianostriana.dam._EjemploDTO.exception;

import jakarta.persistence.EntityNotFoundException;

public class MonumentoNotFoundException extends EntityNotFoundException {


    public MonumentoNotFoundException(){super("El monumento no se ha encontrado");}
    public MonumentoNotFoundException(Long id){super("El monumento con el id "+id+" no se ha encontrado");}
}
