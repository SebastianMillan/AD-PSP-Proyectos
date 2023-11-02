package com.salesianostriana.dam.U2.E02_Ejercicio1.repositories;

import com.salesianostriana.dam.U2.E02_Ejercicio1.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}