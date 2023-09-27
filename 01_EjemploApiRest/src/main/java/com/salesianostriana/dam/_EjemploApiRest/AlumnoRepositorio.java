package com.salesianostriana.dam._EjemploApiRest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AlumnoRepositorio  extends JpaRepository<Alumno, Long> {
}
