package com.salesianostriana.dam._EjemploDTO.repository;

import com.salesianostriana.dam._EjemploDTO.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
