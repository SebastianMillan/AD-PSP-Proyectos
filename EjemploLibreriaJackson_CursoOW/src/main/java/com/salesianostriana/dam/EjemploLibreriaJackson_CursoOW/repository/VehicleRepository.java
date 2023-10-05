package com.salesianostriana.dam.EjemploLibreriaJackson_CursoOW.repository;

import com.salesianostriana.dam.EjemploLibreriaJackson_CursoOW.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
