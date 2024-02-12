package com.salesianostriana.dam.UploadingFiles_Example.repository;

import com.salesianostriana.dam.UploadingFiles_Example.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}