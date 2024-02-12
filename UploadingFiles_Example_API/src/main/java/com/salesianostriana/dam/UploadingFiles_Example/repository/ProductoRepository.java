package com.salesianostriana.dam.UploadingFiles_Example.repository;

import com.salesianostriana.dam.UploadingFiles_Example.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}