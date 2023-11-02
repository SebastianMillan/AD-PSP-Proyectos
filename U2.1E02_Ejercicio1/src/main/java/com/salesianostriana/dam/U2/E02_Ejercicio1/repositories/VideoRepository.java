package com.salesianostriana.dam.U2.E02_Ejercicio1.repositories;

import com.salesianostriana.dam.U2.E02_Ejercicio1.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}